package collections.tree;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javafx.scene.control.TreeItem;
import javafx.scene.image.ImageView;
import loaders.LoadingPictures;
import entities.MessageEvent;

public class TreeNode {
	MessageEvent data;
	private final Map<String, TreeNode> children;
	private Integer visitOrder = 0;
	

	public Integer getVisitOrder() {
		return visitOrder;
	}

	public void setVisitOrder(Integer visitOrder) {
		this.visitOrder = visitOrder;
	}

	public MessageEvent getData() {
		return data;
	}

	public TreeNode(MessageEvent messageEvent) {
		children = new Hashtable<>();
		this.data = messageEvent;
	}

	public Map<String, TreeNode> getChildren() {
		return children;
	}

	public void attachNode(MessageEvent messageEvent) {
		final List<String> path = messageEvent.getSubjects();
		if (path.size() == 0) {
			return;
		}

		final String key = path.get(0);

		final TreeNode child;
		if (children.containsKey(key)) {
			child = children.get(key);
		} else {
			child = new TreeNode(new MessageEvent(messageEvent.getMessage(), key,
					new ArrayList<String>(), messageEvent.getSender()));
			children.put(key, child);
		}
		child.data.setSubjects(path.subList(1, path.size()));
		child.attachNode(child.data);
	}

	public void print(final int level) {
		final StringBuilder build = new StringBuilder();
		for (int i = 0; i < level; i++) {
			build.append("\t");
		}
		for (final String key : children.keySet()) {
			System.out.println(build.toString() + "- " + key);
			children.get(key).print(level + 1);
		}
	}

	public TreeItem<TreeNode> createTree(TreeNode inputNode) {
		TreeItem<TreeNode> item = new TreeItem<TreeNode>(inputNode);
		for (final String key : children.keySet()) {
			item.setGraphic(new ImageView(LoadingPictures.getSubjectImage()));
			item.getChildren().add(
					children.get(key).createTree(children.get(key)));
		}
		return item;
	}

}
