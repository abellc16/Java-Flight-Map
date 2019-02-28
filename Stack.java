/**
 * @author Camby Abell
 * @assignment assg7_Abell
 * @filename Stack.java
 */

package assg7_Abell;


public class Stack<E> implements StackInterface<E> 
{
	private Node<E> top;
	
	/**
	 * Creates an empty stack
	 */
	public Stack() 
	{
		top = null;
	}
	
	/**
	 * Determines whether the stack is empty.
	 * @return True if the stack is empty and false otherwise
	 */
	public boolean isEmpty() 
	{
		return top == null;
	}

	/**
	 * Removes all the items from the stack.
	 * Postcondition: Stack is empty.
	 */
	public void popAll() 
	{
		top = null;
	}

	/**
	 * Adds an item to the top of the stack.
	 * @param newItem The item to be added.
	 * @throws StackException if newItem cannot be placed on the stack.
	 */
	public void push(E newItem) throws StackException 
	{
		top = new Node<E>(newItem, top);
	}

	/**
	 * Removes the top of a stack.
	 * @return The item that was most recently added to the stack.
	 * @throws StackException if the stack is empty.
	 */
	public E pop() throws StackException 
	{
		if(!isEmpty())
		{
			Node<E> temp = top;
			top = top.getNext();
			return temp.getItem();
		}
		else
		{
			throw new StackException("StackException on pop: stack empty");
		}
	}

	/**
	 * Retrieves the top of a stack.
	 * @return The item that was most recently added to the stack.
	 * @throws StackException if the stack is empty.
	 */
	public E peek() throws StackException 
	{
		if(!isEmpty())
		{
			return top.getItem();
		}
		else
		{
			throw new StackException("StackException on peek: stack empty");
		}
	}
}
