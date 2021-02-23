package expressionTreeConverter;
//for Binary Tree
public class Node {
	public Object element;
	
	public Node leftChild;
	public Node rightChild;
	
	public Node(Object o) {
		this(o, null, null);
	}
	
	public Node(Object o, Node l, Node r) {
		element = o;
		leftChild = l;
		rightChild = r;
	}
	
	public String toString() {
		return this.element.toString();
	}
}
