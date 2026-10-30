import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        
        for(int sc : scoville){
            pq.add(sc);
        }
        
        while(K > pq.peek() && pq.size() > 1){
            pq.add(pq.poll() + (pq.poll() * 2));
            answer++;
        }
        
        if(K > pq.peek()) return -1;
        
        
        return answer;
    }
}