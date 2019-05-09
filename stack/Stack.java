/**
 * 
 */
package uy.edu.um.adt.stack;


/**
 * @author danielpereda
 *
 */
public interface Stack<T> extends Iterable<T>{

	void push(T oValueToAdd);
	
	T pop();
	
	T peek();
	
	int size();
	
}
