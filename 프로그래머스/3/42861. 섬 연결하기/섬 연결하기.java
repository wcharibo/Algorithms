import java.util.*;

class Solution {
    int[] sets;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        sets = new int[n];
        for(int i = 0; i < n; i++) sets[i] = i;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for(int[] cost : costs) pq.add(cost);
        
        while(!pq.isEmpty()){
            int[] con = pq.poll();
            
            if(union(con[0], con[1]) == true){
                answer += con[2];
            }
        }
        
        return answer;
    }
    
    private int find(int child){
        if(child == sets[child]) return sets[child];
        
        return sets[child] = find(sets[child]);
    }
    
    private boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb) return false;
        
        sets[pb] = pa;
        
        return true;
    }
}