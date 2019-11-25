/**
 
/* 8 Level order traversal of a tree is breadth first traversal for the tree.
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
     /* queue method 
      * O(n) time complexity - n is number of nodes of BT.
      */ 
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            
            for (int i = 0; i< size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
    
    /* BFS */
   public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        result = bfs(levelNodes, result);
        return result;
   }
   
   private List<List<Integer>> bfs(List<TreeNode> levelNodes, List<List<Integer>> result){
       if (levelNodes.isEmpty()) return result;
       
       List<Integer> level = new ArrayList<>();
       List<TreeNode> nextLevelNodes = new ArrayList<>();
       int len = levelNodes.size();
       for (int i = 0; i < len; i++){
           TreeNode node = levelNodes.get(i);
           level.add(node.val);
           if (node.left != null){
               nextLevelNodes.add(node.left);
           }
           if (node.right != null){
               nextLevelNodes.add(node.right);
           }
       }
       result.add(level);
       bfs(nextLevelNodes, result);
       return result;
   }
}
