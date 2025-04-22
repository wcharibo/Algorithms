#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = n - lost.size();
    
    vector<int> loss(n+1, 0);
    vector<int> rental(n+1, 0);
    
    for(int i : lost) loss[i] = 1;
    for(int i: reserve) rental[i] = 1;
    
    for(int i = 0; i<=n; i++){
        if(loss[i]&rental[i] == 1){
            loss[i] = 0;
            rental[i] = 0;
            answer++;
        }
    }
    
    lost.clear();
    for(int i = 0; i<=n; i++) if(loss[i]==1) lost.push_back(i);
    
    for(int i : lost){
        if(rental[i-1] == 1){
            rental[i-1] = 0;
            answer++;
        }else if(rental[i+1] == 1){
            rental[i+1] = 0;
            answer++;
        }
    }
    
    
    return answer;
}