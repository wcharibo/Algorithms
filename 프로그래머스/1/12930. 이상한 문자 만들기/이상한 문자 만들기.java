class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if((int)temp >= 65 && (int)temp < 97) temp+=32;
            if((int)temp == 32){
                cnt = 0;
                answer+=temp;
            }
            else if(cnt%2 == 0){
                answer+=(char)(temp-32);
                cnt+=1;
            }
            else{
                answer+=temp;
                cnt+=1;
            }

        }
        return answer;
    }
}
