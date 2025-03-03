#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = false;
    int p = 0, y = 0;
    
    for(char i : s){
        if(+i == 80 || +i== 112) p++;
        else if(+i == 89 || +i== 121) y++;
    }
    
    if(p==y) return true;
    
    return answer;
}