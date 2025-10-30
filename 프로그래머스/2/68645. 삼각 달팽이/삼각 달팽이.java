import java.util.*;
class Solution {
    int[][] dirs= {{1, 0}, {0, 1}, {-1, -1}};
    
    public int[] solution(int n) {
        int size = 0;
        for(int i = 1; i <= n; i++){
            size+=i;
        }
        int[] answer = new int[size];
        int[][] worm = new int[n][n];
        
        int cnt = 0;
        int dir = 0;
        int start = 1;
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            worm[cur[0]][cur[1]] = start++;
            
            int[] next = {cur[0] + dirs[dir][0], cur[1] + dirs[dir][1]};
            
            if(0 <= next[0] && next[0] < n && 0 <= next[1] && next[1] < n){
                if(worm[next[0]][next[1]] == 0){
                    q.add(next);
                }else{
                    dir = (dir + 1)%3;
                    next = new int[]{cur[0] + dirs[dir][0], cur[1] + dirs[dir][1]};
                    if(0 <= next[0] && next[0] < n && 0 <= next[1] && next[1] < n){}
                    if(worm[next[0]][next[1]] == 0){
                        q.add(next);
                    }
                    
                }
            }else{
                dir = (dir + 1)%3;
                next = new int[]{cur[0] + dirs[dir][0], cur[1] + dirs[dir][1]};
                if(0 <= next[0] && next[0] < n && 0 <= next[1] && next[1] < n){
                    if(worm[next[0]][next[1]] == 0){
                    q.add(next);
                }
                }
                
            }
        }

        int idx = 0;
        for(int[] i : worm) {
            for(int j : i){
                if(j != 0){
                    answer[idx++] = j;
                }
            }
        }
        
        return answer;
    }
}