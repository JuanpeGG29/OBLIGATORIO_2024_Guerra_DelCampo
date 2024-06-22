package TADs.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class SearchBinaryTreeImpl<T extends Comparable<T>> implements BinaryTree<T> {

    private TreeNode<T> root;

    public void add(T oElement) {
        TreeNode<T> oElementToAdd = new TreeNode<T>(oElement);

        if (root == null) {

            root = oElementToAdd;

        } else {

            root.add(oElement);

        }
    }

    public boolean contains(T oElement) {

        return contains(oElement, root);
    }

    private boolean contains(T oElementToSearch, TreeNode<T> oTree) {
        boolean bContains = false;

        if (oTree != null) {

            int nValue = oElementToSearch.compareTo(oTree.getValue());

            if (nValue == 0) {

                bContains = true;

            } else if (nValue > 0) {

                bContains = contains(oElementToSearch, oTree.getRight());

            } else {

                bContains = contains(oElementToSearch, oTree.getLeft());

            }

        }

        return bContains;
    }

    public void remove(T oElement) {

        if (root != null) {

            root.remove(oElement);

        }

    }

    public T find(T oElement) {

        return find(oElement, root);
    }

    private T find(T oElementToSearch, TreeNode<T> oTree) {
        T oSearchedElement = null;

        if (oTree != null) {

            int nValue = oElementToSearch.compareTo(oTree.getValue());

            if (nValue == 0) {

                oSearchedElement = oTree.getValue();

            } else if (nValue > 0) {

                oSearchedElement = find(oElementToSearch, oTree.getRight());

            } else {

                oSearchedElement = find(oElementToSearch, oTree.getLeft());

            }

        }

        return oSearchedElement;
    }

    public List<T> preOrder() {
        List<T> colValues = new ArrayList<T>();

        if (root != null) {

            colValues.addAll(root.preOrderTraverse());

        }

        return colValues;
    }

    public List<T> posOrder() {
        List<T> colValues = new ArrayList<T>();

        if (root != null) {

            colValues.addAll(root.postOrderTraverse());

        }

        return colValues;
    }

    public List<T> inOrder() {
        List<T> colValues = new ArrayList<T>();

        if (root != null) {

            colValues.addAll(root.inOrderTraverse());

        }

        return colValues;
    }

    public List<T> rangeSearch(T lowerBound, T upperBound) {
        List<T> result = new ArrayList<>();
        rangeSearchHelper(root, lowerBound, upperBound, result);
        return result;
    }

    private void rangeSearchHelper(TreeNode<T> node, T lowerBound, T upperBound, List<T> result) {
        if (node == null) {
            return;
        }

        if (node.getValue().compareTo(lowerBound) > 0) {
            rangeSearchHelper(node.getLeft(), lowerBound, upperBound, result);
        }

        if (node.getValue().compareTo(lowerBound) >= 0 && node.getValue().compareTo(upperBound) <= 0) {
            result.add(node.getValue());
        }

        if (node.getValue().compareTo(upperBound) < 0) {
            rangeSearchHelper(node.getRight(), lowerBound, upperBound, result);
        }
    }

}
