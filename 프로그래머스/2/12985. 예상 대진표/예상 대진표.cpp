#include <iostream>
#include <cmath>

using namespace std;

int solution(int n, int a, int b)
{
    int answer = 0, cnt=0;
    a--;
    b--;
    for(int i = 20; i>0; i--){
        if(a/int(pow(2,i)) != b/int(pow(2,i))){cnt=i+1;break;}
    }
    
    if(cnt==0) answer=1;
    else answer=cnt;
    
    return answer;
}