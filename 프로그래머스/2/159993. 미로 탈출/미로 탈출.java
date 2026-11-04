import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int MAX_ROW = maps.length;
        int MAX_COL = maps[0].length();
        int[] start = new int[2];
        int[] end = new int[2];
        boolean[][] vis = new boolean[MAX_ROW][MAX_COL];
        
        for(int i = 0; i < MAX_ROW; i++){
            for(int j = 0; j < MAX_COL; j++){
                if('S' == maps[i].charAt(j)){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[] {start[0], start[1], 0});
        vis[start[0]][start[1]] = true;
        boolean exitOpen = false;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(!exitOpen && 'L' == maps[cur[0]].charAt(cur[1])){
                
                exitOpen = true;
                for(boolean[] a : vis){
                    Arrays.fill(a, false);
                }
                while(!q.isEmpty()){
                    q.poll();
                }
                vis[cur[0]][cur[1]] = true;
            }
            
            if(exitOpen && 'E' == maps[cur[0]].charAt(cur[1])){
                return cur[2];
            }
            
            for(int[] dir: dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                
                if(0 <= nr && nr < MAX_ROW && 0 <= nc && nc < MAX_COL && 'X' != maps[nr].charAt(nc) && !vis[nr][nc]){
                    vis[nr][nc] = true;
                    q.add(new int[] {nr, nc, cur[2] + 1});
                }
            }
            
        }
        
        
        
        return -1;
    }
}