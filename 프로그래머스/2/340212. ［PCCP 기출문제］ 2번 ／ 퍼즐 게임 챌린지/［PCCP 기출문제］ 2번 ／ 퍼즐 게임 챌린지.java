class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int maxLevel = 0;
        for(int i = 0; i < diffs.length; i++) maxLevel = Math.max(maxLevel, diffs[i]);
        
        int start = 1;
        int end = maxLevel;
        
        while(start <= end){
            int mid = (start + end)/2;
            long time = times[0];
            
            for(int i = 1; i < diffs.length; i++){
                time += ((diffs[i] > mid ? diffs[i] - mid : 0)*(times[i] + times[i-1]) + times[i]);
            }
            
            if(time > limit){
                start = mid + 1;
            }else{
                answer = Math.min(answer, mid);
                end = mid - 1;
            }
        }
        
        return answer;
    }
}