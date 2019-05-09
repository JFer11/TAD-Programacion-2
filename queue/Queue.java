/**
 * 
 */
package uy.edu.um.adt.queue;

/**
 * @author danielpereda
 *
 */
public interface Queue<T> extends Iterable<T>{

	void enqueue(T oValue);
	
	T dequeue() throws EmptyQueue;
	
	boolean contains(T oValue);
	
	int size();
	
}
