package tests.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Consumer;

import javafx.scene.image.ImageView;
import loaders.LoadingPictures;

import org.junit.Test;

import collections.tree.TreeRootWrapper;
import entities.MessageEvent;

public class TreeRootWrapperTest {

	@Test
	public void test() 
	{
		
		TreeRootWrapper tree = TreeRootWrapper.getInstance(null);
		
		ArrayList<String> rootArray = new ArrayList<>();
		rootArray.add("root");

		
		
		ArrayList<String> subjects2 = new ArrayList<>();
		subjects2.add("root");
		subjects2.add("denlillemand");

		ArrayList<String> subjects3 = new ArrayList<>();
		subjects3.add("root");
		subjects3.add("denlillemand");
		subjects3.add("yo");

		ArrayList<String> subjects4 = new ArrayList<>();
		subjects4.add("root");
		subjects4.add("denlillemand");
		subjects4.add("hmm");

		ArrayList<String> subjects5 = new ArrayList<>();
		subjects5.add("root");
		subjects5.add("denlillemand");
		subjects5.add("hi");

		ArrayList<String> subjects6 = new ArrayList<>();
		subjects6.add("root");
		subjects6.add("denlillemand");
		subjects6.add("hmm");
		
		ArrayList<String> subjects7 = new ArrayList<>();
		subjects7.add("root");
		subjects7.add("denlillemand");
		subjects7.add("yo");
		subjects7.add("okay");
		
		ArrayList<String> subjects8 = new ArrayList<>();
		subjects8.add("root");
		subjects8.add("herpderp");
		subjects8.add("bar");
		subjects8.add("muhh");
		
		ArrayList<String> subjects9 = new ArrayList<>();
		subjects9.add("root");
		subjects9.add("herpderp");
		subjects9.add("bat");
		
		ArrayList<String> subjects10 = new ArrayList<>();
		subjects10.add("root");
		subjects10.add("herpderp");
		subjects10.add("baz");
		


		MessageEvent root = new  MessageEvent("root","root", rootArray, "root");
		
		
		MessageEvent event2 = new MessageEvent("message2","", subjects2, "denlillemand");
		MessageEvent event3 = new MessageEvent("message3","", subjects3, "denlillemand");
		MessageEvent event4 = new MessageEvent("message4","", subjects4, "denlillemand");
		MessageEvent event5 = new MessageEvent("message5","", subjects5, "denlillemand");
		MessageEvent event6 = new MessageEvent("message6","", subjects6, "denlillemand");
		MessageEvent event7 = new MessageEvent("message7","", subjects7, "denlillemand");
		MessageEvent event8 = new MessageEvent("message8","", subjects8, "denlillemand");
		MessageEvent event9 = new MessageEvent("message9","", subjects9, "denlillemand");
		MessageEvent event10 = new MessageEvent("message10","", subjects10, "denlillemand");
		

		tree.setRoot(root);
		tree.publicAttachNode(event2);
		tree.publicAttachNode(event3);
		tree.publicAttachNode(event4);
		tree.publicAttachNode(event5);
		tree.publicAttachNode(event6);
		tree.publicAttachNode(event7);
		tree.publicAttachNode(event8);
		tree.publicAttachNode(event9);
		tree.publicAttachNode(event10);
		
		tree.print();
		
		//tree.printIterator(tree.breadthfirst());
		//tree.printIterator(tree.postorder());
		//tree.printIterator(tree.preorder());
		
		/**
		 * 
	 * tl;dr -Preorder printer ud på vejen nedad, og kører ud i alle børnene før
	 * den går tilbage. og tager endnu et barn.
	 *
	 * -PostOrder kører rekursivt igennem det hele, og så når tingne returner
	 * bliver de printet ud, det betyder at vi får en print nede fra det
	 * nederste barn først helt ude til venstre.
	 * 
		 */
		
	}

}
