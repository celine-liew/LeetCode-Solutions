import java.util.*;

/* 
423. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Example
Example 1:

Input: "([)]"
Output: False
Example 2:

Challenge
Use O(n) time, n is the number of parentheses.
*/

public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // String s = "()";
        
        Map<String, String> map = new HashMap<String, String>() {{
            put( "]", "[");
            put(")", "(");
            put("}", "{");
        }};
        System.out.println(map);
        
       Stack<String> stack = new Stack<>(); 
       
       int i = 0;
       while(i < s.length()){
        //   stack.forEach(System.out::println);
            String c = s.charAt(i) +"";
            
            String closing = map.get(c);
            if (closing != null){
                if (stack.empty()) return false;
                String checking = stack.peek();
                /* note that == checks if both same object */
                if (checking != null && closing.equals(checking)) {
                    stack.pop();
                } else{
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
            i++;
       }
    //   stack.forEach(System.out::println);
       return stack.empty();
    }
}
