package linkedStructureGeneralTrees;

public class Noter 
{
/** Starter på side 333 i bogen. (Der er ikke nogen general implementation, det er bare en forklaring
 * af at vi burde tage den anden implementation og ændre left + right referencerne til noget andet. herp
 * fucking derp.)
 * Linked Structure for General Trees
When representing a binary tree with a linked structure, each node explicitly maintains
fields left and right as references to individual children. For a general tree,
there is no a priori limit on the number of children that a node may have. A natural
way to realize a general tree T as a linked structure is to have each node store a
single container of references to its children. For example, a children field of a
node can be an array or list of references to the children of the node (if any). Such
a linked representation is schematically illustrated in Figure 8.12.
 */
	
	
	/** 
	 * En linked Structure  for et general tree, har jo så 
	 * en ubegrænset mængde af børn, Så det betyder at  noden har:
	 * -En container til børn.
	 * -En reference til parent.
	 * -En value.
	 */
	
/**
 * Figure 8.12: The linked structure for a general tree: (a) the structure of a node; (b) a
larger portion of the data structure associated with a node and its children.
Table 8.2 summarizes the performance of the implementation of a general tree
using a linked structure. The analysis is left as an exercise (R-8.13), but we note
that, by using a collection to store the children of each position p, we can implement
children(p) by simply iterating that collection.
Method Running Time
size, isEmpty O(1)
root, parent, isRoot, isInternal, isExternal O(1)
numChildren(p) O(1)
children(p) O(cp +1)
depth(p) O(dp +1)
height O(n)
Table 8.2: Running times of the accessor methods of an n-node general tree implemented
with a linked structure. We let cp denote the number of children of a
position p, and dp its depth. The space usage is O(n).
 */
}
