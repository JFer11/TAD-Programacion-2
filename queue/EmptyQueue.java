/**
 * 
 */
package uy.edu.um.adt.queue;

/**
 * @author danielpereda
 *
 */
public class EmptyQueue extends Exception {

	/**
	 * @param arg0
	 * @param arg1
	 */
	public EmptyQueue(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * @param arg0
	 */
	public EmptyQueue(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public EmptyQueue(Throwable arg0) {
		super(arg0);
	}

}
