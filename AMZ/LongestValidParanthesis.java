 /* using DP approach 
 Time complexity  : O(n). Single traversal of string to fill dp array is done.
 * Space complexity : O(n). dp array of size n is used.
 */
 
 public int longestValidParentheses(String s) {
        // write your code here
       int maxLen = 0;
       int sLen = s.length();
       int dp[] = new int[sLen];
       
       
       for (int i = 1; i < sLen; i++) {
           if (s.charAt(i) == ')') {
               int previous = i - dp[i-1] - 1;
               if (previous >= 0 && s.charAt(previous) == '(') {
                   dp[i] = dp[i-1] + 2 + (previous > 0 ? dp[previous-1] : 0);
               }
               maxLen = Math.max(maxLen, dp[i]);
           }
       }
       return maxLen;
    }
