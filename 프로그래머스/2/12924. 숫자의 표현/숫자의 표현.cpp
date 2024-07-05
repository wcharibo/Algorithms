#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0, sum_cnt = 0, sub_cnt = 0, temp = 0;
    
    while(sub_cnt<n){
        if(temp>=n){
            sub_cnt++;
            temp-=sub_cnt;
        }
        else{
            sum_cnt++;
            temp+=sum_cnt;
        }
        if(temp==n) answer++;
    }
    return answer;
}