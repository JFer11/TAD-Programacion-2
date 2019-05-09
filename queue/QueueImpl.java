/**
 * 
 */
package uy.edu.um.adt.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author danielpereda
 *
 */
public class QueueImpl<T> implements Queue<T> {

	private Deque<T> internalQueue;
	
	public QueueImpl() {
		internalQueue = new ArrayDeque<T>();
	}
	
	@Override
	public void enqueue(T oValue) {
		internalQueue.addLast(oValue);
	}

	@Override
	public T dequeue() throws EmptyQueue {
		if (internalQueue.size() == 0) {
			
			throw new EmptyQueue("The Queue is empty");
		}
		
		return internalQueue.removeFirst();
	}

	@Override
	public int size() {
		return internalQueue.size();
	}

	@Override
	public Iterator<T> iterator() {
		return internalQueue.iterator();
	}

	@Override
	public boolean contains(T oValue) {
		return internalQueue.contains(oValue);
	}

}
