/**
 * 
 */
package uy.edu.um.adt.binarytree.withnode;

import java.util.List;

/**
 * @author pegardan
 *
 */
public interface BinaryTreeWithNode<K extends Comparable<K>, V> {

	void add(K oKey, V oValue);

	void remove(K oKey);
	
	boolean contains(K oKey);
	
	V find(K oKey);

	List<K> preOrder();

	List<K> posOrder();

	List<K> inOrder();

}
