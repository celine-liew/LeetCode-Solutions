
/* 
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
    */
import java.util.Arrays; 


class Solution {
    static int jump(int[] nums) {
        
        
        /* O(n^2) , TLE */
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        // fills from index 1 to dp.length-1 
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);

        // for (int i = 1; i < dp.length; i++) {
        //     dp[i] = Integer.MAX_VALUE; // int max
        // }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1];
        
        /*  dp[i] to store the maximum index (i-1)th jump can reach */ 
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];
        int i = 2;
        while (dp[i-1] < nums.length-1){ // we can stop when dp[i-i] reaches nums.length-1 already. no need to continue!
            int tempMax = 0;
            for (int j = dp[i-2]+1; j <= dp[i-1]; j++){
                System.out.println(j + " nums[j] :" + nums[j] );
                System.out.println(tempMax + " next: " + (nums[j] + j));
                tempMax = Math.max(tempMax, nums[j] + j);
            }
            dp[i] = tempMax;
            i++;
            System.out.println(Arrays.toString(dp));
        }
        
        return i - 1;
    }
    
    /* to test this */
    public static void main (String[] args)  {
        int[] nums = { 2,3,1,1,4 };
        int ans = jump(nums);
        System.out.println(ans);
  }
}
