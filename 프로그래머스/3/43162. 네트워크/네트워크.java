class Solution {
    
    boolean[] vis;
    
    void dfs(int[][] computers, int computerID){
        
        vis[computerID] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(computers[computerID][i] == 1 && vis[i] == false){
                dfs(computers, i);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        vis = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                dfs(computers, i);
                answer++;
            }
        }
        
        return answer;
    }
}