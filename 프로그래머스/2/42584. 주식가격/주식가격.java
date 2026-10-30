import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        
        for(int i = 0; i < prices.length; i++){
            
            while(!pq.isEmpty() && pq.peek()[0] > prices[i]){
                int[] fallen = pq.poll();
                answer[fallen[1]] = i - fallen[1];
            }
            
            pq.add(new int[] {prices[i], i});
        }
        
        while(!pq.isEmpty()){
            int[] fallen = pq.poll();
            answer[fallen[1]] = prices.length - fallen[1] - 1;
        }
        
        return answer;
    }
}