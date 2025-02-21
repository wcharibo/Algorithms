#include <string>

using namespace std;

string solution(int n) {
    string answer = "";
    
    while(n!=0){
        int rsd = n%3;
        n/=3;
        
        if(rsd == 0) n--;
        
        answer = "412"[rsd] + answer;
    }
    
    return answer;
}