package assg7_Abell;

public interface StackInterface<E> {

	/**
	 * Determines whether the stack is empty.
	 * @return True if the stack is empty and false otherwise
	 */
	public boolean isEmpty();
	
	
	/**
	 * Removes all the items from the stack.
	 * Postcondition: Stack is empty.
	 */
	public void popAll();

	
	/**
	 * Adds an item to the top of the stack.
	 * @param newItem The item to be added.
	 * @throws StackException if newItem cannot be placed on the stack.
	 */
	public void push(E newItem) throws StackException;

	
	/**
	 * Removes the top of a stack.
	 * @return The item that was most recently added to the stack.
	 * @throws StackException if the stack is empty.
	 */
	public E pop() throws StackException;

	
	/**
	 * Retrieves the top of a stack.
	 * @return The item that was most recently added to the stack.
	 * @throws StackException if the stack is empty.
	 */
	public E peek() throws StackException;
}
