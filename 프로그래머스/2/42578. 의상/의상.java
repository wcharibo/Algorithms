import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> m = new HashMap<>();
        
        for(String[] cloth : clothes){
            int val = m.getOrDefault(cloth[1], 0);
            
            m.put(cloth[1], m.getOrDefault(cloth[1], 0 ) + 1);
        }
        
        for(int val : m.values()){
            answer *= val + 1;
        }
        
        return answer - 1;
    }
}