package collections.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entities.MessageEvent;

public class NoterForEachRemaining {
	/**
	 * 	/**
	 * iterator.forEachRemaining(new Consumer<TreeNode<MessageEvent>>() {
			@Override
			public void accept(TreeNode<MessageEvent> t) {
				if (t.getChildren().isEmpty()) {
					item.setGraphic(new ImageView(LoadingPictures
							.getMessageImage()));
				} else {
					item.getChildren().add(createTree(t));
					item.setGraphic(new ImageView(LoadingPictures
							.getSubjectImage()));
				}

			}

		});
	 */
	
	
	/**
	 * public Iterator<TreeNode<MessageEvent>> postorder() {
		List<TreeNode<MessageEvent>> snapshot = new ArrayList<>();
		if (!isEmpty())
			postorderSubtree(root, snapshot); // fill the snapshot recursively
		return snapshot.iterator();
	}

	private void postorderSubtree(TreeNode<MessageEvent> node,
			List<TreeNode<MessageEvent>> snapshot) {
		for (TreeNode<MessageEvent> c : node.getChildren()) {
			postorderSubtree(c, snapshot);
		}
		snapshot.add(node);
	}
	 */
	 
}
