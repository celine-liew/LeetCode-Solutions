import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] loop(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //int complement = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] hash (int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashmap.containsKey(complement))
                return new int[]{hashmap.get(complement), i};
            hashmap.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main (String[] args) {
        int[] set = new int[]{1, 2, 3, 4, 5};
        int target = 8;
        //loop(set, target);
        System.out.println(Arrays.toString(loop(set, target)));
        System.out.println(Arrays.toString(hash(set, target)));
    }
}