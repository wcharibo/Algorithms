import java.util.*;

class Solution {
    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int sizeR = storage.length;
        int sizeC = storage[0].length();
        int[][] wareHouse = new int[sizeR + 2][sizeC + 2];
        List<int[]>[] containers = new List[26];
        
        
        for(int i = 0; i < containers.length; i++){
            containers[i] = new ArrayList<int[]>();
        }
        
        for(int i = 0; i < storage.length; i++){
            for(int j = 0; j < storage[i].length(); j++){
                containers[storage[i].charAt(j) - 'A'].add(new int[]{i + 1,j + 1});
            }
        }
        
        for(int[] i : wareHouse) Arrays.fill(i, 1);
        
        for(int i = 0; i <= sizeR + 1; i++){
            wareHouse[i][0] = wareHouse[i][sizeC+1] = -1;
        }
        
        for(int i = 0; i <= sizeC + 1; i++){
            wareHouse[0][i] = wareHouse[sizeR+1][i] = -1;
        }
        
        for(String request : requests){
            // System.out.println("-------" + request + "-------");
            // for(int[] i : wareHouse) System.out.println(Arrays.toString(i));
            
            if(request.length() > 1){
                for(int [] i : containers[request.charAt(0) - 'A']){
                    wareHouse[i[0]][i[1]] = 0;
                }
                containers[request.charAt(0) - 'A'].clear();
            }else{
                int size = containers[request.charAt(0) - 'A'].size();
                List<int[]> willDelete = new ArrayList<>();
                
                for(int i = size - 1; i >= 0; i--){
                    int[] cur = containers[request.charAt(0) - 'A'].get(i);
                    if(check(cur, wareHouse)){
                        willDelete.add(cur);
                        containers[request.charAt(0) - 'A'].remove(i);
                    }
                }
                
                for(int[] d : willDelete){
                    wareHouse[d[0]][d[1]] = 0;
                }
                
            }
            
            // System.out.println("--------------");
            // for(int[] i : wareHouse) System.out.println(Arrays.toString(i));
        }
        
        for(int i = 1; i <= sizeR; i++){
            for(int j = 1; j <= sizeC; j++){
                if(wareHouse[i][j] == 1) answer++;
            }
        }
        
        
        return answer;
    }
    
    boolean check(int[] cur, int[][] wareHouse){
        int cnt = 0;
        
        if(bfs(cur[0], cur[1], wareHouse, new boolean[wareHouse.length][wareHouse[0].length])){
            return true;
        }
        
        return false;
    }
    
    boolean bfs(int r, int c, int[][] wareHouse, boolean[][] vis){
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{r,c});
        vis[r][c] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(wareHouse[cur[0]][cur[1]] == -1){
                return true;
            }
            
            for(int i = 0; i < 4; i++){
                int nr = cur[0] + dirs[i][0];
                int nc = cur[1] + dirs[i][1];
                
                if(!vis[nr][nc] && wareHouse[nr][nc] != 1){
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        
        
        return false;
    }
}