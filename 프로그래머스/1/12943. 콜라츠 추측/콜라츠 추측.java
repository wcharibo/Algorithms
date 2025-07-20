class Solution {
    public int solution(int num) {
        int answer = 0;
        long insertedNum = num;
        
        while(insertedNum != 1){
            long dividedNum = insertedNum % 2;
            answer++;
            if(dividedNum == 0){
                insertedNum /= 2;
            }else if( dividedNum == 1){
                insertedNum *= 3;
                insertedNum++;
            }
            
            if(answer >= 500) return -1;
        } 
        
        return answer;
    }
}