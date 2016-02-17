package binaryTrees;

public class Noter {
	/**
	 * A binary tree is an ordered tree with the following properties:
1. Every node has at most two children.
2. Each child node is labeled as being either a left child or a right child.
3. A left child precedes a right child in the order of children of a node.
The subtree rooted at a left or right child of an internal node v is called a left subtree
or right subtree, respectively, of v. A binary tree is proper if each node has either
zero or two children. Some people also refer to such trees as being full binary
trees. Thus, in a proper binary tree, every internal node has exactly two children.
A binary tree that is not proper is improper.


(Hvor mange noder tingne kan have max ved hvert level af depth:)
Properties of Binary Trees
Binary trees have several interesting properties dealing with relationships between
their heights and number of nodes. We denote the set of all nodes of a tree T at the
same depth d as level d of T. In a binary tree, level 0 has at most one node (the
root), level 1 has at most two nodes (the children of the root), level 2 has at most
four nodes, and so on. (See Figure 8.7.) In general, level d has at most 2d nodes.

Vi kommer til at have en linked Repræsentation af et binært træ,

Så det betyder at vores nodes  Har:
-reference til parent
-reference til  left child
-reference til right child
-værdi. 



addRoot(e): Creates a root for an empty tree, storing e as the element,
and returns the position of that root; an error occurs if the
tree is not empty.

addLeft(p, e): Creates a left child of position p, storing element e, and
returns the position of the new node; an error occurs if p
already has a left child.

addRight(p, e): Creates a right child of position p, storing element e, and
returns the position of the new node; an error occurs if p
already has a right child.

set(p, e): Replaces the element stored at position p with element e,
and returns the previously stored element.


attach(p, T1, T2): Attaches the internal structure of trees T1 and T2 as the
respective left and right subtrees of leaf position p and
resets T1 and T2 to empty trees; an error condition occurs
if p is not a leaf.


remove(p): Removes the node at position p, replacing it with its child
(if any), and returns the element that had been stored at p;
an error occurs if p has two children.

Performance of the Linked Binary Tree Implementation
To summarize the efficiencies of the linked structure representation, we analyze the
running times of the LinkedBinaryTree methods, including derived methods that
are inherited from the AbstractTree and AbstractBinaryTree classes:
• The size method, implemented in LinkedBinaryTree, uses an instance variable
storing the number of nodes of a tree and therefore takes O(1) time.
Method isEmpty, inherited from AbstractTree, relies on a single call to size
and thus takes O(1) time.
• The accessor methods root, left, right, and parent are implemented directly
in LinkedBinaryTree and take O(1) time each. The sibling, children, and
numChildren methods are derived in AbstractBinaryTree using on a constant
number of calls to these other accessors, so they run in O(1) time as well.
• The isInternal and isExternalmethods, inherited from the AbstractTree class,
rely on a call to numChildren, and thus run in O(1) time as well. The isRoot
method, also implemented in AbstractTree, relies on a comparison to the
result of the root method and runs in O(1) time.
• The update method, set, clearly runs in O(1) time. More significantly, all of
the methods addRoot, addLeft, addRight, attach, and remove run in O(1)
time, as each involves relinking only a constant number of parent-child relationships
per operation.
• Methods depth and height were each analyzed in Section 8.1.3. The depth
method at position p runs in O(dp+1) time where dp is its depth; the height
method on the root of the tree runs in O(n) time.
The overall space requirement of this data structure is O(n), for a tree with
n nodes, as there is an instance of the Node class for every node, in addition to the
top-level size and root fields. Table 8.1 summarizes the performance of the linked
structure implementation of a binary tree.
Method Running Time
size, isEmpty O(1)
root, parent, left, right, sibling, children, numChildren O(1)
isInternal, isExternal, isRoot O(1)
addRoot, addLeft, addRight, set, attach, remove O(1)
depth(p) O(dp+1)
height O(n)
Table 8.1: Running times for the methods of an n-node binary tree implemented
with a linked structure. The space usage is O(n).
	 */
}
