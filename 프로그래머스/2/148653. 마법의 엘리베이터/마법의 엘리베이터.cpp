#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

int solution(int storey) {
    int answer = 0;
    vector<int> a;
    
    for(int i = 8; i >= 0; i--){
        int temp = storey/pow(10,i);
        if(temp != 0) a.push_back(temp);
    }
    
    for(auto i = a.rbegin(); i != a.rend(); i++) *i -= 10*(*(i+1));
        
    
    for(auto i = a.rbegin(); i != a.rend(); i++){
        if(i != a.rend()-1 && *i == 5){
            if(*(i+1)>=5){
                answer+=5;
                *(i+1)+=1;
            }
            else answer+=5;
        }
        else if(*i <= 5){
            answer+=*i;
        }
        else{
            answer+=(10-*i);
            if(i!=a.rend()-1) *(i+1)+=1;
            else answer++;
        }
    }
    return answer;
}