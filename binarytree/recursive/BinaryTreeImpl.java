/**
 * 
 */
package uy.edu.um.adt.binarytree.recursive;

import java.util.ArrayList;

/**
 * @author danielpereda
 *
 */
public class BinaryTreeImpl<OtherType extends Comparable<OtherType>> implements
		BinaryTree<OtherType> {

	private BinaryTree<OtherType> leftChild;

	private BinaryTree<OtherType> rightChild;

	private OtherType value;
	
	private int amount;
	
	/**
	 * Default constructor
	 * @param oValue
	 * @throws InvalidValue 
	 */
	public BinaryTreeImpl(OtherType oValue) throws InvalidValue {
		
		if (oValue == null) {
			
			throw new InvalidValue("El valor a insertar no puede ser vacio");
			
		}
		
		value = oValue;
		amount = 1;
	}
	
	public ArrayList<OtherType> inOrder(){
		ArrayList <OtherType> inOrder= new ArrayList <OtherType>();
		if(getRightChild() != null){
			inOrder.addAll(getRightChild().inOrder());
		}
		inOrder.add(getRoot());
		if(getLeftChild() != null){
			inOrder.addAll(getRightChild().inOrder());
		}		
		return inOrder;		
	}

	@Override
	public void add(OtherType oElement) throws InvalidValue {
		
		if (oElement == null) { // Se verifica precondiciones
			
			throw new InvalidValue("El valor a insertar no puede ser vacio");
			
		}
		
		int nCompare = oElement.compareTo(getValue());
		
		if (nCompare == 0) { // se esta intentan agregar el mismo elemento
			
			amount++;
			
		} else if (nCompare > 0) {
			
			if (hasRightChild()) {
				
				rightChild.add(oElement);
				
			} else {
				
				rightChild = new BinaryTreeImpl<OtherType>(oElement);
				
			}
			
		} else {
			
			if (hasLeftChild()) {
				
				leftChild.add(oElement);
				
			} else {
				
				leftChild = new BinaryTreeImpl<OtherType>(oElement);
				
			}
			
		}
		
	}
	
	@Override
	public BinaryTree<OtherType> delete(OtherType oElement) {
		BinaryTree<OtherType> oToReturn = this;
		
		if (oElement != null) {
			
			int nCompare = oElement.compareTo(getValue());

			if (nCompare > 0) {
				
				if (hasRightChild()) {
					
					rightChild = rightChild.delete(oElement);
					
				}
				
			} else if (nCompare < 0) {
				
				if (hasLeftChild()) {
					
					leftChild = leftChild.delete(oElement);
					
				}
				
			} else { // El elemento que quiero eliminar es donde estoy parado
				
				if (amount > 1) { // Si hay mas de una inserccion voy disminuyendo el contador
					
					amount--;
					
				} else {
					
					if (!hasLeftChild() && !hasRightChild()) { // Si no tiene hijos elimino.
						
						oToReturn = null;
						
					} else { // En el caso que tenga por lo menos un hijo
						
						if (hasRightChild()) { // Se da prioridad a el arbol derecho
					
							OtherType oMin = rightChild.getMinValue();
							
							value = oMin;
							
							rightChild = rightChild.delete(oMin);
							
						} else {
							
							OtherType oMax = leftChild.getMaxValue();
							
							value = oMax;
							
							leftChild = leftChild.delete(oMax);
						
						}
					}
				}
				
			}
			
			
		}
		
		return oToReturn;
	}

	@Override
	public boolean exists(OtherType oElement) {
		boolean bReturn = false;
		
		if (oElement != null) {
			
			int nCompare = oElement.compareTo(getValue());
		
			if (nCompare == 0) {
			
				// Encontre el valor
				
				bReturn = true;
				
			} else if (nCompare > 0) {
				
				// El elemento es mayor
				
				if (hasRightChild()) {
					
					bReturn = rightChild.exists(oElement);
					
				}
				
			} else {
				
				if (hasLeftChild()) {
					
					bReturn = leftChild.exists(oElement);
					
				}				
				
			}
			
		}
		
		return bReturn;
	}
	
	public BinaryTree <OtherType> find(OtherType oElement) throws InvalidValue{
		
		BinaryTree <OtherType> arbolBuscado = new BinaryTreeImpl<OtherType>(null);		
		
		if(getRoot().compareTo(oElement) == 0){
			arbolBuscado=this;
		}
		if(getRoot().compareTo(oElement) < 0){
			arbolBuscado=this.getLeftChild().find(oElement);
		}
		if(getRoot().compareTo(oElement) > 0){
			arbolBuscado=this.getRightChild().find(oElement);
		}
		
		return arbolBuscado;
		
	}
	
	/**
	 * @return the left
	 */
	public BinaryTree<OtherType> getLeftChild() {
		return leftChild;
	}

	/**
	 * @return the right
	 */
	public BinaryTree<OtherType> getRightChild() {
		return rightChild;
	}

	@Override
	public int getHeight() {
		int nHeight = 1;
		int nRightHeight = 0;
		int nLeftHeight = 0;
		
		if (hasRightChild()) {
			
			nRightHeight = rightChild.getHeight();
			
		} 
		
		if (hasLeftChild()) {
			
			nLeftHeight = leftChild.getHeight();
			
		}
		
		if (nRightHeight > nLeftHeight) {
			
			nHeight += nRightHeight;
			
		} else {
			
			nHeight += nLeftHeight;
			
		}
		
		return nHeight;
	}
	
	
	/**
	 * @return the value
	 */
	public OtherType getValue() {
		return value;
	}

	public OtherType getMinValue() {
		OtherType oMin = value;
		
		if (hasLeftChild()) {
		
			oMin = leftChild.getMinValue();
			
		}
		
		return oMin;
	}

	@Override
	public OtherType getMaxValue() {
		OtherType oMax = value;
		
		if (hasRightChild()) {
			
			oMax = rightChild.getMaxValue();
			
		}
		
		return oMax;
	}
	
	@Override
	public OtherType getRoot() {
		return getValue();
	}
	
	private boolean hasRightChild() {
		
		return rightChild != null;
		
	}
	
	private boolean hasLeftChild() {
		
		return leftChild != null;
	}
}
