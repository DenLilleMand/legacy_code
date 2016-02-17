package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ServerMain implements Runnable{
 ServerSocket ss;
 Vector&lt;ClientTasks&gt; online;
 Socket skt;
 // 1 server contructor
 public ServerMain(){
 Controller.online = online;
 Controller.ss = ss;
 Controller.skt = skt;
 try{
 ss = new ServerSocket(8881);
 Controller.serverlog.appendText(&quot;Listening on port 8888\n&quot;);
 // store clientTasks object in online vector which has two parameters socket and username
 online = new Vector&lt;ClientTasks&gt;();
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 
 public void activity(){
 try{
 while(true){
 skt = ss.accept();
 Verifier vf = new Verifier(skt);
 Controller.serverlog.appendText(&quot;Client has been accepted\n&quot;);
 vf.start();
 }
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 public void quitServer(){
 try {
 ss.close();
 } catch (IOException ex) {
 Logger.getLogger(ServerMain.class.getName()).log(Level.SEVERE, null, ex);
 }
 skt = null;
 ss = null;
 }
 // verifier takes in socket
 class Verifier extends Thread{
 Socket sock;
 DataInputStream dis;
 DataOutputStream dos;
 String un;
 // in verifier constructor we create dis and dos odjects
 public Verifier(Socket st){
 try{
 sock = st;
 // creating each user his own dis and dos objects
 dis = new DataInputStream(sock.getInputStream());
 dos = new DataOutputStream(sock.getOutputStream());
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 // 1.****check method reads intial msg from client
 public void check(){
 try{
 // we want to check if the username exist or not
 boolean found = false;
 do{
 boolean exists = false;
 // first reading from client
 un = dis.readUTF();
 Controller.serverlog.appendText(&quot;Username is requesting join ::::::::::::::&quot;+un+&quot;\n&quot;);
 for(int i=0;i
 ClientTasks tsk = online.get(i);
 String usn = tsk.username;
 if(usn.equalsIgnoreCase(un)){
 dos.writeUTF(&quot;The username is currently being used&quot;);
// dos.flush();
 Controller.serverlog.appendText(&quot;The username &quot;+un+&quot;is currently being used \n&quot;);
 exists = true;
 break;
 }
 }
 if(exists==false){
 dos.writeUTF(&quot;You successfully loggedin &quot;);
// dos.close();
 Controller.serverlog.appendText(&quot;The username &quot;+un+&quot;is logged in successfully \n&quot;);
 found = true;
 }
 // we loop back to beginning of when found == fasle
 }while(found == false);
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 // calls the check method to verify the client
 public void run(){
 check();
 ClientTasks ct = new ClientTasks(sock,un);
 // adding clientTask object to vector online
 online.add(ct);
 ct.start();
 }
 }
 // bussiness logic to send msg to clients
 class ClientTasks extends Thread{
 Socket sock;
 DataInputStream dis;
 DataOutputStream dos;
 String username;
 // contructor takes two parameters socket and username
 // each user has his own dos and dis object to send and read nessages
 public ClientTasks(Socket skt, String un){
 Controller.dis = dis;
 Controller.dos = dos;
 sock = skt;
 try{
 dis = new DataInputStream(sock.getInputStream());
 dos = new DataOutputStream(sock.getOutputStream());
 username = un;
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 // send message to all clients
 public void sendGeneral(String msg) {
 try{
 for(int i=0;i
 ClientTasks tsk = online.get(i);
 // calling the sendmsg method
 tsk.sendMsg(username + &quot;: &quot; +msg);
 Controller.serverlog.appendText(username + &quot;: &quot; +msg+&quot;\n&quot;);
 }
 }catch(Exception ex){
 
 }
 }
 // writting message to client
 public void sendMsg(String msg){
 try{
 dos.writeUTF(msg);
 dos.flush();
 whoIsOnline();
 
 Controller.serverlog.appendText(msg+&quot;\n&quot;);
 }catch(Exception ex){
 //ex.printStackTrace();
 }
 }
 // sending private message
 public void sendPrivate(String user,String msg){
 try{
 for(int i=0;i
 ClientTasks tsk = online.get(i);
 String nem = tsk.username;
 if(nem.equalsIgnoreCase(user)){
 tsk.sendMsg(username + &quot;: &quot; + msg);
 Controller.serverlog.appendText(username + &quot;: &quot; + msg+&quot;\n&quot;);
 dos.writeUTF(username + &quot;: &quot; +msg);
// dos.flush();
 break;
 }
 }
 }catch(Exception ex){
 ex.printStackTrace();
 }
 }
 // checks who is online
 public void whoIsOnline(){
 try{
 String who = &quot;&quot;;
 for(int i=0;i&lt;online.size();i++){
 ClientTasks tsk = online.get(i);
 who += tsk.username + &quot;,&quot;;
 }
 dos.writeUTF(&quot;pase2347&quot;+who);
// dos.flush();
 Controller.serverlog.appendText(&quot;Memeber Online :&quot;+who+&quot;\n&quot;);
 }catch(Exception ex){
 
 }
 }
 
 public void run(){
 sendGeneral(&quot; joined chat&quot;);
 try{
 while(true){
 String listen = dis.readUTF();
 listen = listen.trim();
 if(listen.startsWith(&quot;pvt&quot;)){
 // substring pvt from the String
 String sent = listen.substring(3);
 // tokenizing the msg got from client
 StringTokenizer tk = new StringTokenizer(sent,&quot; &quot;);
 // got the username
 String nem = tk.nextToken();
 String msg = &quot;&quot;;
 while(tk.hasMoreTokens()){
 // looping the message back to original with space in it
 msg += &quot; &quot; + tk.nextToken();
 }
 // calling the sendprivate msg with two parameters name and message
 sendPrivate(nem,msg);
 }else if(listen.equals(&quot;online&quot;)){
 // invoking the whois online method
 whoIsOnline();
 }else{
 // send msg to general if the above selections where not meet
 sendGeneral(listen);
 }
 }
 }catch(Exception ex){
 // allerting the server if the client logs out or gets a network problem
 Controller.serverlog.appendText(&quot;client lost connection &quot;+ username+&quot;\n&quot;);
 sendGeneral(username + &quot; left chat&quot;);
 for(int i=0;i&lt;online.size();i++){
 ClientTasks tsk = online.get(i);
 String nem = tsk.username;
 if(nem.equalsIgnoreCase(username)){
 // removes the client from the vector
 online.remove(i);
 break;
 }
 }
 
 }
 }
 }
 @Override
 public void run(){
 try{
 activity();
 }catch(Exception e){
 Controller.serverlog.appendText(&quot;First object is created&quot;+e);
 }}
}
&lt;pre&gt;