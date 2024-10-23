#include <string>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

long long solution(int n, vector<int> works) {
    long long answer = 0;
    
    sort(works.begin(), works.end(), greater<int>());
    
    vector<int>::iterator max_index = works.begin();
    
    while(n>0){
        n-=1;
        *max_index-=1;
        if(max_index+1 != works.end() && max_index != works.begin()){
            if(*max_index < *(max_index+1)) max_index++;
            else if(*max_index == *(max_index+1) || *max_index == *(max_index-1)) max_index = works.begin();
        }
        else {
            if(max_index == works.begin() && *max_index < *(max_index+1)) max_index++;
            else max_index = works.begin();
        }
        
    }
    
    for(int i : works) if(i>0) answer+=pow(i,2);
    
    return answer;
}