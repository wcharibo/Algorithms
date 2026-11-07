import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] roads = new int[N][N];
        for(int[] r : roads) Arrays.fill(r, 10001);
        
        for(int[] r : road){
            roads[r[0] - 1][r[1] - 1] = Math.min(roads[r[0] - 1][r[1] - 1], r[2]);
            roads[r[1] - 1][r[0] - 1] = Math.min(roads[r[1] - 1][r[0] - 1], r[2]);
        }
        
        
        int[] vis = new int[N];
        Arrays.fill(vis, Integer.MAX_VALUE);
        vis[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for(int i = 0; i < N; i++){
            if(roads[0][i] < 10001){
                pq.add(new int[] {0, i, 0 + roads[0][i]});
            }
        }
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(vis[cur[1]] == Integer.MAX_VALUE){
                vis[cur[1]] = vis[cur[0]] + roads[cur[0]][cur[1]];
                
                for(int i = 0; i < N; i++){
                    if(vis[i] == Integer.MAX_VALUE && roads[cur[1]][i] < 10001){
                        pq.add(new int[] {cur[1], i, vis[cur[1]] + roads[cur[1]][i]});
                    }
                }   
            }
        }
        
        for(int i : vis){
            // System.out.print(" " + i);
            if(i <= K){
                answer++;
            }
        }
        
        return answer;
    }
}