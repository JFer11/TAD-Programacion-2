/**
 * 
 */
package uy.edu.um.adt.binarytree.withnode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pegardan
 * @param <T>
 *
 */
public class SearchBinaryTreeImpl<K extends Comparable<K>, V> implements
		BinaryTreeWithNode<K, V> {

	private TreeNode<K, V> root;

	@Override
	public void add(K oKey, V oValue) {
		TreeNode<K, V> oElementToAdd = new TreeNode<K, V>(oKey, oValue);

		if (root == null) {

			root = oElementToAdd;

		} else {

			root.add(oKey, oValue);

		}
	}
	
	public V find(K oKey) {

		return find(oKey, root);
	}

	private V find(K oKeyToSearch, TreeNode<K, V> oRoot) {
		V oValue = null;
		
		if (oRoot != null) {

			int nValue = oKeyToSearch.compareTo(oRoot.getKey());

			if (nValue == 0) {
				
				oValue = oRoot.getValue();
				
			} else if (nValue > 0) {
				
				oValue = find(oKeyToSearch, oRoot.getRight());
				
			} else {
				
				oValue = find(oKeyToSearch, oRoot.getLeft());
				
			}

		}

		return oValue;
	}

	public boolean contains(K oKey) {

		return contains(oKey, root);
	}

	private boolean contains(K oKeyToSearch, TreeNode<K, V> oRoot) {
		boolean bContains = false;
		
		if (oRoot != null) {

			int nValue = oKeyToSearch.compareTo(oRoot.getKey());

			if (nValue == 0) {
				
				bContains = true;
				
			} else if (nValue > 0) {
				
				bContains = contains(oKeyToSearch, oRoot.getRight());
				
			} else {
				
				bContains = contains(oKeyToSearch, oRoot.getLeft());
				
			}

		}

		return bContains;
	}


	@Override
	public void remove(K oKey) {

		if (root != null) {

			root = root.remove(oKey);

		}

	}

	@Override
	public List<K> preOrder() {
		List<K> colValues = new ArrayList<K>();

		if (root != null) {

			colValues.addAll(root.preOrderTraverse());

		}

		return colValues;
	}

	@Override
	public List<K> posOrder() {
		List<K> colValues = new ArrayList<K>();

		if (root != null) {

			colValues.addAll(root.postOrderTraverse());

		}

		return colValues;
	}

	@Override
	public List<K> inOrder() {
		List<K> colValues = new ArrayList<K>();

		if (root != null) {

			colValues.addAll(root.inOrderTraverse());

		}

		return colValues;
	}

}
