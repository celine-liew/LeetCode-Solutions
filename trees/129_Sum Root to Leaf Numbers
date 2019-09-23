/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/* 
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
*/


const sumNumbers = function(root) {
  if (!root)
    return 0;
  return addPath(root,0)
};

const addPath = (node, value) => {
  // console.log(node.val, value)
  let num = value*10 + node.val;
  
  if (node.left && node.right){
    return addPath(node.left, num) + addPath(node.right, num)
  }
  if (node.right){
    return addPath(node.right, num)
  }
  if (node.left){
    return addPath(node.left, num);
  }
  
  return num;
}



function TreeNode(val) {
     this.val = val;
     this.left = this.right = null;
}

let root = new TreeNode(1);
root.left = new TreeNode(2)
root.right = new TreeNode(3)

console.log(sumNumbers(root))
