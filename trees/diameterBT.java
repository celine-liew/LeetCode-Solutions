/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 1181. Diameter of Binary Tree
中文English
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example
Example 1:

Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:
 */

public class Solution {
    /**
     * @param root: a root of binary tree
     * @return: return a integer
     */
    private int maxPath = 0;
     
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        pathHelper(root);
        return maxPath;
    }
    
    public int pathHelper(TreeNode node){
        
        if (node == null) return 0;
        
        int left = pathHelper(node.left);
        int right = pathHelper(node.right);
        maxPath = Math.max(maxPath, left + right);
        
        return Math.max(left, right) + 1;
    }
}
