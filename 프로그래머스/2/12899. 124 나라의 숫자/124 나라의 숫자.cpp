#include <string>

using namespace std;

string solution(int n) {
    string answer = "";
    
    while(n!=0){
        char num = n%3 + '0';
        n/=3;
        
        if(num == '0'){
            num+=4;
            n--;
        }
        
        answer = num + answer;
    }
    
    return answer;
}