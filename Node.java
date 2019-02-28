package assg7_Abell;

public class Node<E> {
	
	private E item;
	private Node<E> next;
	
	/**
	 * Creates a new linked list node.
	 * @param newItem The data item to be placed in the node.
	 */
	public Node(E newItem) 
	{
		item = newItem;
		next = null;
	}
	
	/** Creates a new linked list node.
	 * @param newItem The data item to be placed in the node.
	 * @param nextNode A link to the next node in the list.
	 */
	public Node(E newItem, Node<E> nextNode)
	{
		item = newItem;
		next = nextNode;
	}
	
	/**
	 * Gets the data item.
	 * @return The data item stored in the node.
	 */
	public E getItem() 
	{
		return item;
	}
	
	/**
	 * Changes the data item in the node.
	 * @param item The new item to be placed in the node.
	 */
	public void setItem(E item) 
	{
		this.item = item;
	}
	
	/**
	 * Gets the link item.
	 * @return A link to the next node in the list.
	 */
	public Node<E> getNext() 
	{
		return next;
	}
	
	/**
	 * Sets the link item.
	 * @param next A reference to the new node to follow this node.
	 */
	public void setNext(Node<E> next) 
	{
		this.next = next;
	}
	
	public String toString() 
	{
		return this.item.toString();
	}
	
	public boolean equals(Object obj) 
	{
		if (obj instanceof Node) {
			@SuppressWarnings("unchecked")
			Node<E> tmp = (Node<E>)obj;
			return tmp.item.equals(this.item);
		}
		return false;
	}
}
