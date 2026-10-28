import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet poke = new HashSet<Integer>();
        
        for(int num : nums){
            poke.add(num);
        }
        
        return poke.size() >= nums.length / 2 ? nums.length / 2 : poke.size();
    }
}