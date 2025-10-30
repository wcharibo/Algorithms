class Solution {
    static int code = 0;
    static int[] tries;
    static int[] checks;
    static int result = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        tries = new int[q.length];
        checks = ans;
        
        for(int i = 0, idx = 0; i < q.length; i++){
            int temp = 0;
            for(int j = 0; j < q[i].length; j++){
                temp |= 1 << q[i][j];
            }
            tries[idx++] = temp;
        }
        
        make(0, 0, n);

        return result;
    }
    
    public boolean check(){
        
        for(int i = 0; i < tries.length; i++){
            int hit = code & tries[i];
            int cnt = 0;
            for(int j = 1; j <= 30; j++){
                if((hit & (1 << j)) > 0) cnt++;
            }
        
            if(cnt != checks[i]){
                
                return false;
            }}
        
        return true;
    }
    
    
    public void make(int idx, int prev, int n){
        if(idx == 5){
            if(check()){
                result++;
            }
            return;
        }
        
        for(int i = prev + 1; i <= n; i++){
            code = code | 1 << i;
            make(idx + 1, i, n);
            code = code ^ 1 << i;
        }
    }
}