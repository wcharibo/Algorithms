import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        int MAX_ROW = board.length;
        int MAX_COL = board[0].length();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int[][] mat = new int[MAX_ROW][MAX_COL];
        int[] start = new int[2];
        
        for(int i = 0; i < MAX_ROW; i++){
            for(int j = 0; j < MAX_COL; j++){
                
                if('R' == board[i].charAt(j)){
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        
        mat[start[0]][start[1]] = 1;
        q.add(new int[] {start[0], start[1], 0});
        
        while(!q.isEmpty()){
            
            int[] cur = q.poll();
            
            if('G' == board[cur[0]].charAt(cur[1])){
                return cur[2];
            }
            
            for(int[] dir: dirs){
                int nr = cur[0];
                int nc = cur[1];
                
                while(0 <= nr && nr < MAX_ROW && 0 <= nc && nc < MAX_COL && !(board[nr].charAt(nc) == 'D')){
                    nr += dir[0];
                    nc += dir[1];
                }
                
                nr -= dir[0];
                nc -= dir[1];
                
                if(mat[nr][nc] != 1){
                    mat[nr][nc] = 1;
                    q.add(new int[] {nr, nc, cur[2] + 1});
                }  
            } 
        }
        
        return -1;
    }
}