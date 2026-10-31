import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int MAX_ROW = maps.length;
        int MAX_COL = maps[0].length;
        int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};
        int[][] vis = new int[MAX_ROW][MAX_COL];
        for(int[] row : vis) Arrays.fill(row, Integer.MAX_VALUE);
        
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
         vis[0][0] = 1;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int[] dir : dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                
                if(0 <= nr && nr < MAX_ROW && 0 <= nc && nc < MAX_COL && maps[nr][nc] == 1 && vis[nr][nc] > vis[cur[0]][cur[1]] + 1){
                    
                    q.add(new int[] {nr, nc});
                    vis[nr][nc] = vis[cur[0]][cur[1]] + 1;
                }
            }
        }
        
        return vis[MAX_ROW - 1][MAX_COL - 1] == Integer.MAX_VALUE ? -1 : vis[MAX_ROW - 1][MAX_COL - 1];
    }
}