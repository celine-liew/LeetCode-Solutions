/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2
 */
var longestUnivaluePath = function(root) {
    
    let ans = 0;
    
    const findPathLength = (node) => {
        if (!node) return 0;
        let left = findPathLength(node.left);
        let right = findPathLength(node.right);
        let arrowLeft = 0, arrowRight =0;
        if (node.left && node.left.val == node.val){
            arrowLeft = left + 1;
        }
        if (node.right && node.right.val == node.val){
            arrowRight = right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight)
    }

    findPathLength(root);
    return ans;
};
