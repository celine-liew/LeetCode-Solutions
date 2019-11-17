/*
433. Number of Islands
Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

Find the number of islands.

Example
Example 1:

Input:
[
  [1,1,0,0,0],
  [0,1,0,0,1],
  [0,0,0,1,1],
  [0,0,0,0,0],
  [0,0,0,0,1]
]
Output:
3
*/

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    private int numSquares;
    private int[] id;
    
    public int numIslands(boolean[][] grid) {
        // write your code here
       
        if (grid == null 
        || grid.length == 0 
        || grid[0] == null
        || grid[0].length == 0){
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j]){
                    numSquares++;
                }
            }
        }
        
        id = new int[row * col];
        for (int i = 0; i < id.length; i++){
            id[i] = i;
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!grid[i][j]){
                    continue;
                }
                
                int check1 = i * col + j;
                
                if (j + 1 < col && grid[i][j+1]){
                    int checkright = check1 + 1;
                    getUnion(check1, checkright);
                }
                
                if (i + 1 < row && grid[i+1][j]){
                    int checkDown = check1 + col;
                    getUnion(check1, checkDown);
                }
            }
        }
        return numSquares;
    }
    
    public void getUnion(int position, int check){
        // System.out.println("left " + position);
        // System.out.println("right " + check);
        int pos = find(position);
        int checked = find(check);
        if (pos != checked){
            id[pos] = checked;
            numSquares--;
        }

    }
    
    public int find(int target){
        while (target != id[target]){
            id[target] = id[id[target]];
            target = id[target];
        }
        
        return target;
    }
   
}
