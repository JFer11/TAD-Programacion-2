/**
 * 
 */
package uy.edu.um.adt.stack;

import java.util.Iterator;

/**
 * @author danielpereda
 * @param <T>
 *
 */
public class StackImpl<T> implements Stack<T> {

	private java.util.Stack<T> internalStack;
	
	public StackImpl() {
		internalStack = new java.util.Stack<T>();
	}
	
	@Override
	public void push(T oValueToAdd) {
		
		internalStack.push(oValueToAdd);
		
	}

	@Override
	public T pop() {
		
		return internalStack.pop();
		
	}

	@Override
	public T peek() {
		
		return internalStack.peek();
	}

	@Override
	public int size() {
		
		return internalStack.size();
	}

	@Override
	public Iterator<T> iterator() {
		return internalStack.iterator();
	}

}
