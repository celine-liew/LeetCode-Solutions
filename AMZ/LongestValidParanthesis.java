 /* using DP approach 
  * Time complexity  : O(n). Single traversal of string to fill dp array is done.
  * Space complexity : O(n). dp array of size n is used.
  */
 
 public int longestValidParentheses(String s) {
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

/* Stack approach 
 * Time  complexity : O(n). n is the length of the given string.
 * Space complexity : O(n). The size of stack can go up to n.
 */ 
public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        stack.push(-1);
        int sLen = s.length();
        
        for (int i = 0; i < sLen; i++){
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.empty()){
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
