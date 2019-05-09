/**
 * 
 */
package uy.edu.um.adt.binarytree.withnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pegardan
 *
 */
public class TreeNode<K extends Comparable<K>, V> {

	private K key;
	
	private V value;

	private TreeNode<K, V> left;

	private TreeNode<K, V> right;

	public TreeNode(K oKey, V oValue) {
		this.key = oKey;
		this.value = oValue;
	}

	public void add(K oKey, V oValue) {		
		TreeNode<K, V> oElementToAdd = new TreeNode<>(oKey, oValue);
		
		if (oKey.compareTo(this.key) > 0) {

			if (right == null) {

				right = oElementToAdd;

			} else {

				right.add(oKey, oValue);

			}

		} else {

			if (left == null) {

				left = oElementToAdd;

			} else {

				left.add(oKey, oValue);

			}
		}

	}

	public TreeNode<K, V> remove(K oKey) {
		int nValue = ((Comparable<K>) oKey).compareTo(key);

		if (nValue > 0) {

			if (right != null) {

				right = right.remove(oKey);

			}

		} else if (nValue < 0) {

			if (left != null) {

				left = left.remove(oKey);

			}
		} else if (left != null && right != null) {

			// Encontre el elemento a eliminar

			TreeNode<K, V> oTemp = right.findMin();
			
			this.key = oTemp.getKey();
			this.value = oTemp.getValue();

			right = right.remove(oTemp.getKey());

		} else {

			if (left != null) {

				return left;

			} else {

				return right;

			}

		}

		return this;
	}

	public List<K> inOrderTraverse() {
		List<K> colList = new ArrayList<K>();

		if (left != null) {

			colList.addAll(left.inOrderTraverse());

		}

		colList.add(this.getKey());

		if (right != null) {

			colList.addAll(right.inOrderTraverse());

		}

		return colList;
	}

	public List<K> preOrderTraverse() {
		List<K> colList = new ArrayList<K>();

		colList.add(getKey());

		if (left != null) {

			colList.addAll(left.preOrderTraverse());

		}

		if (right != null) {

			colList.addAll(right.preOrderTraverse());

		}

		return colList;
	}

	public List<K> postOrderTraverse() {
		List<K> colList = new ArrayList<K>();

		if (left != null) {

			colList.addAll(left.preOrderTraverse());

		}

		if (right != null) {

			colList.addAll(right.preOrderTraverse());

		}

		colList.add(getKey());

		return colList;
	}

	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public TreeNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<K, V> left) {
		this.left = left;
	}

	public TreeNode<K, V> getRight() {
		return right;
	}

	public void setRigth(TreeNode<K, V> rigth) {
		this.right = rigth;
	}

	public TreeNode<K, V> findMin() {
		 TreeNode<K, V> oReturn = this;

		if (left != null) {

			oReturn = left.findMin();

		}

		return oReturn;
	}

}
