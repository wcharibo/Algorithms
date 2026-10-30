import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int curTime = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]) : a[2] - b[2]);
        
        PriorityQueue<int[]> queueJobs = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        
        for(int i = 0; i < jobs.length; i++){
            queueJobs.add(new int[] {i, jobs[i][0], jobs[i][1]});
        } 
        
        
        while(!queueJobs.isEmpty() || !pq.isEmpty()){
            
            while(!queueJobs.isEmpty() && curTime >= queueJobs.peek()[1]){
                pq.add(queueJobs.poll());
            }
            
            if(pq.isEmpty() && !queueJobs.isEmpty()){
                curTime = queueJobs.peek()[1];
            }else if(!pq.isEmpty()){
                int[] curJob = pq.poll();
                curTime += curJob[2];
                answer += curTime - curJob[1];
            }
            
            // System.out.println("time: " + curTime + " answer: " + answer);
        }
        
        return answer/jobs.length;
    }
}