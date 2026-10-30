import java.util.*;

class Solution {
    int MAX_LENGTH;
    int TARGET;
    int[] pos;
    int answer;
    
    void comb(int[] numbers, int idx, int cur){
        
        if(idx == MAX_LENGTH + 1){
            if(cur == TARGET) answer++;
            return;
        }
        
        
        if(Math.abs(TARGET - cur) <= pos[idx]){
            comb(numbers, idx + 1, cur + numbers[idx]);
            comb(numbers, idx + 1, cur - numbers[idx]);
        }
    }
    
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        MAX_LENGTH = numbers.length - 1;
        TARGET = target;
        pos = new int[numbers.length];
        pos[MAX_LENGTH] = numbers[MAX_LENGTH];
        
        for(int i = MAX_LENGTH - 1; i >= 0; i--){
            pos[i] = pos[i+1] + numbers[i];
        }
        
        comb(numbers, 0, 0);
        
        return answer;
    }
}