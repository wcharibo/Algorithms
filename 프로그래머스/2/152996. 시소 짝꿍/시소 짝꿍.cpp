#include <string>
#include <vector>

using namespace std;

long long solution(vector<int> weights) {
    long long answer = 0;
    vector<long long> cnt(1001, 0);
    vector<vector<long long>> div(4001, vector<long long> (3, 0));
    
    for(int i : weights) cnt[i]++;
    
    for(int i = 100; i < cnt.size(); i++){
        if(cnt[i]>0){
            answer+=(cnt[i]*(cnt[i]-1)/2);
            for(int j = 0; j<3; j++){
                div[i*(j+2)][j] = cnt[i];
            }
        }
        
    }
    
    for(int i=200; i<div.size(); i++){
        for(int j = 0; j<3; j++){
            for(int k = j+1; k<3; k++){
                answer+=div[i][j]*div[i][k];
            }
        }
    }
    
    return answer;
}