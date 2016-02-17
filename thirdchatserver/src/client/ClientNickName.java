//link: http://javaislife.wordpress.com/2013/12/01/multi-threaded-chat-application-designed-in-javafx/
package client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClientNickName implements Runnable {
 
Socket st = null;
 DataInputStream dis = null;
 DataOutputStream dos = null;
 private String nickname = null;
 private String ip = null;
 
public ClientNickName(String ip ,String nickname) {
 this.nickname = nickname;
 this.ip =ip;
 }
 
 public void ClientNickNameMain() {
 try {
 
boolean accepted = false;
 do {
 accepted = false;
 dos.writeUTF(nickname);
 // reading back from server
 String reply = dis.readUTF();
 
if (reply.contains(&quot;currently&quot;)) {
 // set the Nickname UI
 ClientSetting.nickLabel.setText(&quot;USERNAME IS IN USE TRY AGAIN !!!!&quot;);
 // it will loop back to accepted = false till all true
 accepted = false;
 } else {
 ClientSetting.outputbox.appendText(reply + &quot;\n&quot;);
 
 // kill the nick UI
 ClientSetting.nickTitledPane.setVisible(false);
 
ClientSetting.sendMessage.setVisible(true);
 accepted = true;
 }
 } while (accepted == false);
 try {
 while (true) {
 String reply = dis.readUTF();
 if (reply.isEmpty()) {
 
 ClientSetting.outputbox.appendText(&quot;Client is empty boss&quot; + reply + &quot;\n&quot;);
 } else {
 if(reply.startsWith(&quot;pase2347&quot;)){
// ClientSetting.OnlineCombo.getItems().clear();
// ClientSetting.xlist.removeAll(ClientSetting.xlist);
 ClientSetting.OnlineLable.setText(&quot;&quot;);
 String usersx[] = reply.replace(&quot;pase2347&quot;, &quot;&quot;).split(&quot;,&quot;);
 for (int a = 0; a &lt; usersx.length; a++) {
 System.err.println(usersx[a]);
 ClientSetting.OnlineLable.appendText(usersx[a]+&quot;\n&quot;);
 ClientSetting.xlist.add(usersx[a]);
 }
 // populate combo
// ClientSetting.OnlineCombo.setItems(ClientSetting.xlist);
 
 }else{
 ClientSetting.outputbox.appendText(reply + &quot;\n&quot;);
 System.out.println(&quot;.........................&quot; + reply);
 }
 }
 
// send messages to server
 // send message through server to all clients
 ClientSetting.sendMessage.setOnAction(new EventHandler&lt;ActionEvent&gt;() {
 @Override
 public void handle(ActionEvent event) {
 String privatemessage = ClientSetting.privatemessage.getText().trim();
 String message = ClientSetting.inputbox.getText().trim();
 String fullmessage = privatemessage+&quot; &quot;+message;
 ClientSetting.inputbox.setText(&quot;&quot;);
 ClientSetting.privatemessage.setText(&quot;&quot;);
 ClientSetting.privateLabel.setText(&quot;&quot;);
 ClientSetting.privateLabel.setVisible(false);
 try {
 
 dos.writeUTF(fullmessage);
 
} catch (IOException ex) {
 Logger.getLogger(ClientNickName.class.getName()).log(Level.SEVERE, null, ex);
 }
 }
 });
 
&amp;nbsp;
 
}
 } catch (Exception ex) {
 ClientSetting.outputbox.appendText(&quot;&quot;
 + &quot; WARNING :\n&quot;
 + &quot;***********************************\n&quot;
 + &quot;**The server has been switched off*\n &quot;
 + &quot;** Please close the application ***\n&quot;
 + &quot;** and open it again.************\n&quot;
 + &quot;***********************************&quot;);
 ClientSetting.OnlineLable.setText(&quot;&quot;);
 ClientSetting.online.setVisible(false);
 ClientSetting.offline.setVisible(true);
 ClientSetting.sendMessage.setDisable(true);
 
}
 } catch (Exception ex) {
 //ex.printStackTrace();
 ClientSetting.outputbox.appendText(&quot;Server Connection error\n&quot;);
 
}
 
}
 
@Override
 public void run() {
 
try {
 // connecting to the server
 st = new Socket(ip, 8881);
 //Creating the dis and dos objects foe the clients
 dis = new DataInputStream(st.getInputStream());
 dos = new DataOutputStream(st.getOutputStream());
 } catch (Exception e) {
// ClientSetting.validationShow.setVisible(true);
 ClientSetting.outputbox.appendText(&quot;Server Authetication Failed Please Try to login again\n&quot;);
// ClientSetting.validationShow.setText(&quot;Your ip address or username is incorrect&quot;);
 
 }
 ClientNickNameMain();
 }
}
&lt;pre&gt;