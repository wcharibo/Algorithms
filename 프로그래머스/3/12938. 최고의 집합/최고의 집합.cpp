#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, int s) {
    vector<int> answer;
    
    while(n > 1){
        
        if(s/n == 0) return {-1,};
        answer.push_back(s/n);
        s-=(s/n);
        n--;
        
    }
    
    answer.push_back(s);
    
    return answer;
}