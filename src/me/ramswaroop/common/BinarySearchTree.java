package me.ramswaroop.common;

import java.util.NoSuchElementException;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 * User: ramswaroop
 * Date: 4/19/15
 * Time: 6:36 PM
 * To change this template go to Preferences | IDE Settings | File and Code Templates
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    public static void main(String[] a) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        /*bst.put(12);
        bst.put(10);
        bst.put(16);
        bst.put(14);
        bst.put(25);
        bst.put(15);
        bst.put(20);
        bst.put(35);
        bst.put(23);
        bst.put(22);
        bst.put(21);
        bst.put(45);
        bst.put(40);
        bst.put(56);
        bst.put(65);
        bst.put(75);
        bst.put(85);*/
        bst.preOrder();
        out.println("");
        bst.inOrder();
        out.println("");
        bst.postOrder();
        out.println("\n" + bst.size());
        out.println(bst.height());
        /*obj.delete();
        out.println("After deletion: ");
        obj.postOrder();*/
        out.print("\nIn Order: ");
        bst.inOrder();
        /*out.println("\nAfter mirroring: ");
        obj.mirror();
        obj.inOrder();*/
        out.println("LCA: " + bst.leastCommonAncestor(bst.root, 6, 8).value);
        out.println("Min: " + bst.min().value);
        out.println("BFT: ");
        bst.breadthFirstTraversal();
        out.println("\nBFT using queue: ");
        bst.breadthFirstTraversalUsingQueue();
        out.println("Is BST: " + bst.isBST());
        /*out.print("Tree to list: ");
        bst.treeToList();*/
        out.print("\nIs height balanced: " + bst.isHeightBalanced());
        out.print("\nDiameter: " + bst.diameter());
    }


    /**
     * Inserts a node into the BST.
     *
     * @param value
     */
    public void put(E value) {
        put(root, value);
    }

    public BinaryNode<E> put(BinaryNode<E> node, E value) {
        BinaryNode<E> newNode = new BinaryNode<>(value, null, null);

        if (node == null) {
            return root = new BinaryNode<>(value, null, null);
        } else {
            if (value.compareTo(node.value) < 0) {
                if (node.left == null) {
                    return node.left = newNode;
                } else {
                    return put(node.left, value);
                }
            } else {
                if (node.right == null) {
                    return node.right = newNode;
                } else {
                    return put(node.right, value);
                }
            }
        }
    }


    /**
     * Returns the node with minimum value.
     *
     * @return
     */
    public BinaryNode<E> min() {
        return min(root);
    }

    public BinaryNode<E> min(BinaryNode<E> node) {
        if (node == null) throw new NoSuchElementException();

        if (node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }


    /**
     * Determines the LCA for a BST
     * <p/>
     * DEFINITION OF LCA:
     * Let T be a rooted tree. The lowest
     * common ancestor between two nodes n1 and
     * n2 is defined as the lowest node in T that has
     * both n1 and n2 as descendants (where we allow
     * a node to be a descendant of itself).
     */
    public void leastCommonAncestor() {
        /*int value1, value2;
        Scanner in = new Scanner(System.in);
        out.println("Enter value 1: ");
        value1 = (E) Integer.valueOf(in.nextLine());
        out.println("Enter value 1: ");
        value2 = (E) in.nextLine();
        out.println("LCA of " + value1 + " and " + value2 + " is: " + leastCommonAncestor(root, value1, value2).value);*/
    }

    public BinaryNode<E> leastCommonAncestor(BinaryNode<E> node, E value1, E value2) {
        if (node == null || value1.compareTo(value2) > 0) throw new NoSuchElementException();

        if (value1.compareTo(node.value) <= 0 && value2.compareTo(node.value) >= 0) {
            return node;
        } else if (value1.compareTo(node.value) > 0 && value2.compareTo(node.value) > 0) {
            return leastCommonAncestor(node.right, value1, value2);
        } else {
            return leastCommonAncestor(node.left, value1, value2);
        }
    }

    public void printList(BinaryNode<E> node) {
        BinaryNode<E> current = node;
        out.print("[");
        if (current == null) {
            out.println("]");
            return;
        }
        while (current.right != node) {
            out.print(current.value + ",");
            current = current.right;
        }
        out.println(current.value + "]");
    }
}