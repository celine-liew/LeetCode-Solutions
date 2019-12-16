/*
Give a dictionary of words and a sentence with all whitespace removed, return the number of sentences you can form by inserting whitespaces to the sentence so that each word can be found in the dictionary.

Example
Example1

Input:
"CatMat"
["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"]
Output: 3
Explanation:
we can form 3 sentences, as follows:
"CatMat" = "Cat" + "Mat"
"CatMat" = "Ca" + "tM" + "at"
"CatMat" = "C" + "at" + "Mat"
*/

public class Solution {
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null || dict.size() == 0) {
            return 0;
        }
        s = s.toLowerCase();
        int sLen = s.length();
        // ignore case - need a new set since String is immutable.
        Set<String> lowerDict = new HashSet<>();
        for (String word : dict){
            String toAdd = word.toLowerCase();
            lowerDict.add(toAdd);
        }
        
        int[] dp = new int[sLen + 1];
        dp[sLen] = 1;
        
       for (int i = sLen-1; i >= 0; i--){
           for (int j = i+1; j <= sLen; j++){
               // substring(i,j) = start i inclusive, end j exclusive.
               String substr = s.substring(i,j);
               if (lowerDict.contains(substr)){
                   dp[i] += dp[j];
               }
           }
       }
        // System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}
