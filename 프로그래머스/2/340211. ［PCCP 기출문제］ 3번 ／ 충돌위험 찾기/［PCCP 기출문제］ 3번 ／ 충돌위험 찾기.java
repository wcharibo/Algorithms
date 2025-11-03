import java.util.*;

class Solution {
    class Robot{
        int[] cur;
        Queue<int[]> dest = new ArrayDeque<>();
        int time;
        
        Robot(int[] cur, List<int[]> dest){
            this.cur = cur;
            for(int[] i : dest){
                this.dest.add(i);
            }
            this.time = 0;
        }
        
        int[] move(){
            int moving;
            if(dest.peek()[0] != cur[0]){
                moving = (dest.peek()[0] - cur[0]) > 0 ? 1 : -1;
                this.cur[0] += moving;
            }else if(dest.peek()[1] != cur[1]){
                moving = (dest.peek()[1] - cur[1]) > 0 ? 1 : -1;
                this.cur[1] += moving;
            }else{
                return new int[]{-1,-1};
            }
            
            if(dest.peek()[0] == cur[0] && dest.peek()[1] == cur[1]) dest.poll();
            
            return this.cur;
        }
    }
    
    class Pair{
        int time;
        boolean alreadyCrashed;
        
        Pair(int time){
            this.time = time;
            this.alreadyCrashed = false;
        }
        
        void crash(){
            this.alreadyCrashed = true;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        Queue<Robot> robots = new ArrayDeque<>();
        Set<int[]> start = new HashSet<>();
        Pair[][] map = new Pair[101][101];
        
        for(int[] route : routes){
            List<int[]> r = new ArrayList<>();
            for(int i = 1; i < route.length; i++){
                r.add(new int[] {points[route[i] - 1][0], points[route[i] -1][1]});
            }
            
            robots.add(new Robot(
                new int[]{points[route[0] - 1][0], points[route[0] -1][1]},
                r
            ));
            
            if(map[points[route[0] - 1][0]][points[route[0] -1][1]] != null){
                if(map[points[route[0] - 1][0]][points[route[0] -1][1]].time == 0){
                    if(!map[points[route[0] - 1][0]][points[route[0] -1][1]].alreadyCrashed){
                        map[points[route[0] - 1][0]][points[route[0] -1][1]].alreadyCrashed = true;
                        answer++;
                    }
                }else{
                    map[points[route[0] - 1][0]][points[route[0] -1][1]] = new Pair(0);
                }
            }else{
                map[points[route[0] - 1][0]][points[route[0] -1][1]] = new Pair(0);
            }
        }
        
        while(!robots.isEmpty()){
            Robot cur = robots.poll();
            // System.out.println(cur.cur[0] + " " + cur.cur[1]);
            
            if(cur.dest.isEmpty() || cur.cur[0] == cur.dest.peek()[0] && cur.cur[1] == cur.dest.peek()[1]){
                continue;
            }
            
            int[] result = cur.move();
            cur.time++;
            
            robots.add(cur);
      
            if(map[result[0]][result[1]] != null){
                if(map[result[0]][result[1]].time == cur.time){
                    if(!map[result[0]][result[1]].alreadyCrashed){
                        map[result[0]][result[1]].alreadyCrashed = true;
                        answer++;
                    }
                }else{
                    map[result[0]][result[1]] = new Pair(cur.time);
                }
            }else{
                map[result[0]][result[1]] = new Pair(cur.time);
            }
        }
        
        
        return answer;
    }
}