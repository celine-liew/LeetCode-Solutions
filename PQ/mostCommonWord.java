/* 1369.
Given a paragraph and a list of banned words, 
return the most frequent word that is not in the list of banned words. 
It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation. 
Words in the paragraph are not case sensitive. The answer is in lowercase.

Example1
Input:  paragraph = "Bob hit a ball, the hit BALL flew far after it was hit." and banned = ["hit"]
Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.

Example2
Input:  paragraph = "a a a b b c c d" and banned = ["a","b"]
Output: "c"
*/

public class Solution {
    /**
     * @param paragraph: 
     * @param banned: 
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> banlist = Arrays.asList(banned);
        Map<String, Integer> count = new HashMap<>();
        String[] words = paragraph.toLowerCase().replaceAll( "[^a-zA-Z\\s]", "" ).split(" ");
        System.out.println(Arrays.toString(words));
        
        for (String word : words){
            if (!banlist.contains(word))
                count.put(word, count.getOrDefault(word, 0) +1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue(count.size(), (a,b) -> count.get(b) - count.get(a));
        for ( String word: count.keySet()){
            queue.offer(word);
        }
        
        return queue.poll();
    }
}
