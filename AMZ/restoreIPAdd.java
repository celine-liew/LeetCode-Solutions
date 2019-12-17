/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

(Your task is to add three dots to this string to make it a valid IP address. Return all possible IP address.)

/* Example: "010010" ==> ["0.10.0.10","0.100.1.0"]
  "25525511135" ===> ["255.255.11.135","255.255.111.35"]
  */ 
*/


public class Solution {
    /**
     * @param s: the IP string
     * @return: All possible valid IP addresses
     */
        private ArrayList<String> ips;
        
    public List<String> restoreIpAddresses(String s) {
        ips = new ArrayList<String>();
        
        if (s == null || s.length() < 4) {
            return ips;
        }
        
        Stack<Integer> stack = new Stack<>();
        restoreHelper(s, ips, 0, stack);
        return ips;
    }
    
    public void restoreHelper(String s, ArrayList<String> ips, 
        int idx, Stack<Integer> stack ){
            
            final String DOT = ".";
            if (stack.size() == 4 && idx == s.length()){
                    String addS = "", check = "";
                for (int i = 0; i <= 3 ; i++){
                    addS += DOT + stack.get(i); 
                    check += stack.get(i);
                }
                // String potentialIP = addS.substring(1);
                // System.out.println(addS.substring(1));
                // System.out.println(check);
                if (check.equals(s)){
                     ips.add(addS.substring(1));
                }
                return;
            }
            
            int tmp = 0;
            for (int i = 0; i < 3; i++){
                if (idx + i >= s.length()) break;
                int checkInt = s.charAt(idx) - '0';
                System.out.println("idx: " + idx + " check: " +checkInt + " I: " + i);
                if (checkInt == 0 & i > 0) {
                    // System.out.println("break");
                    // because 010 doesnt make sense!
                    break;
                }
                tmp *= 10;
                int addInt = s.charAt(idx+i) - '0';
                tmp += addInt;
                // System.out.println(tmp);
                if (tmp < 256){
                    stack.push(tmp);
                    restoreHelper(s, ips, idx+i+1, stack);
                    stack.pop();
                }
            }
        }
    
}
