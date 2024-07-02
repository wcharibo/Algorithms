#include<string>

using namespace std;

bool solution(string s)
{
    bool answer = false;
    int temp = 0;
    
    for(int i=0; i<s.size(); i++){
        if(s[i]=='(') temp++;
        else {
            temp--;
            if(temp==-1) return answer;
        }
    }
    
    if(temp==0) answer = true;
    
    return answer;
}