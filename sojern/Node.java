

public class Node<E extends Number> {
	E val;
	Node<E> left;
	Node<E> right;
	public Node(E data){
		val = data;
		left = null;
		right = null;
	}
}
