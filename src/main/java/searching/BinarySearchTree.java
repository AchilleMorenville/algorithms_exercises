package searching;

import utils.BinaryNode;

/**
 * You are given a binary search tree (BST) whose nodes implement the following interface
 *
 *  interface Node {
 *      // Returns the value of the node
 *      int getValue();
 *
 *      // Returns the left child of the node
 *      Node getLeft();
 *
 *      // Returns the right child of the node
 *      Node getRight();
 *  }
 *
 * We ask you to complete the ceil method, which take as argument the root of a BST and an integer `value`.
 * This methods finds a node `N` in the BST such that
 *  - Its value is greater or equal than `value`
 *  - No nodes whose value is greater than `value` has a value lower than `N`
 *  and returns its value.
 *  If no such node exists, the method returns null.
 *
 *  For example, consider the following tree
 *
 *                              12
 *                              |
 *                 8 ------------------------ 18
 *                  |                          |
 *           3 ------------ 11       14 -------------- 20
 *                          |        |
 *                     9 ---         --- 15
 *
 * - The ceiled valued of 11 is 11
 * - The ceiled valued of 4 is 8
 * - The ceiled valued of 21 is null
 */
public class BinarySearchTree {


    /**
     * Returns the ceiled value of `value` in the tree rooted at `root`
     *
     * @param root the root of the tree
     * @param value the value we want to ceil
     */
    public static Integer ceil(BinaryNode root, int value) {
        // BEGIN STRIP
        return tail_ceil(root, value, null);
        // END STRIP
        // STUDENT return null;
    }

    // BEGIN STRIP
    /**
     * Tail recursive version of the ceil method. Passing the current best as parameter allows
     * to have the recursive call as last parameter and thus avoid call stack explosion
     *
     * @param root the root of the tree
     * @param value the value we want to ceil
     * @param currentBest the current best value found for the ceiling
     */
    private static Integer tail_ceil(BinaryNode root, int value, Integer currentBest) {
        if (root == null) {
            return currentBest;
        }
        int nodeValue = root.getValue();
        if (nodeValue == value) {
            return value;
        } else if (nodeValue > value) {
            if (currentBest == null || nodeValue < currentBest) {
                return tail_ceil(root.getLeft(), value, nodeValue);
            } else {
                return tail_ceil(root.getLeft(), value, currentBest);
            }
        } else {
            return tail_ceil(root.getRight(), value, currentBest);
        }
    }
    // END STRIP
}