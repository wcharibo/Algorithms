import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int MAX_ROW = board.length;
        int MAX_COL = board[0].length;
        
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int[][][] fares = new int[MAX_ROW][MAX_COL][2];
        for(int[][] fare : fares) for(int[] fee: fare) Arrays.fill(fee, 10000000);
        
        Queue<int[]> q = new ArrayDeque<>();
        
        fares[0][0][0] = 0;
        fares[0][0][1] = 0;
        q.add(new int[] {0,0});
        
        while(!q.isEmpty()){
            int cr = q.peek()[0];
            int cc = q.poll()[1];
            
            for(int i = 0; i < dirs.length; i++){
                int nr = cr + dirs[i][0];
                int nc = cc + dirs[i][1];
                
                if(0 <= nr && nr < MAX_ROW && 0 <= nc && nc < MAX_COL && board[nr][nc] == 0){
                    boolean flag = false;
                    
                    for(int j = 0; j < fares[cr][cc].length; j++){
                        int posFare = fares[cr][cc][j] + 100 + (i%2 == j ? 0 : 500);
                        
                        if(fares[nr][nc][i%2] > posFare){
                            fares[nr][nc][i%2] = posFare;
                            if(flag == false) q.add(new int[] {nr, nc});
                            flag = true;
                        }
                    }
                }
            }
        }
        
        
        
        
        
        return Math.min(fares[MAX_ROW - 1][MAX_COL - 1][0], fares[MAX_ROW - 1][MAX_COL - 1][1]);
    }
}