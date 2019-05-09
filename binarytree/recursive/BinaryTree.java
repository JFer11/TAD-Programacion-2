/**
 * 
 */
package uy.edu.um.adt.binarytree.recursive;

import java.util.ArrayList;

/**
 * Representa un arbol binario de busqueda
 * 
 * @author danielpereda
 */
public interface BinaryTree <AnyType extends Comparable<AnyType>> {

	ArrayList <AnyType> inOrder();
	
	void add(AnyType oElement) throws InvalidValue;
	
	BinaryTree<AnyType> delete(AnyType oElement);
	
	boolean exists(AnyType oElement);
	
	AnyType getMinValue();
	
	AnyType getMaxValue();
	
	int getHeight();
	
	AnyType getRoot();
	
	BinaryTree<AnyType> getLeftChild();
	
	BinaryTree<AnyType> getRightChild();
	
	BinaryTree<AnyType> find (AnyType oElement) throws InvalidValue;
	
}
