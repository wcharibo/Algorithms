import java.util.*;

class Solution {
    static int result = 0;
    static int[] nums;
    static int[] pairs;
    static int max;
    
    public int solution(int n) {

        nums = new int[2];
        pairs = new int[n*2];
        max = n*2;
    
        for(int i = 1; i <= n; i++){
            nums[1]++;
        }
        
        make(0);
        
        
        return result;
    }
    
    public void make(int idx){
        if(idx == max){
            result++;
            // System.out.println(Arrays.toString(pairs));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                pairs[idx] = i;
                nums[i]--;
                if(i > 0){
                    nums[0]++;
                }
                make(idx+1);
                nums[i]++;
                if(i > 0){
                    nums[0]--;
                }
            }
            
        }
        
        
        
    }
}