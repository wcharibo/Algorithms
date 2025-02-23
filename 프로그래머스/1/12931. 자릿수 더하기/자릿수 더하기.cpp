#include <iostream>

using namespace std;
int solution(int n)
{
    int answer = 0, start = 10;
    
    for(int i = 0; i < 9; i++) {
        int cur = n%start;
        answer+=(cur/(start/10));
        n-=cur;
        if(n==0) break;
        start*=10;
    }
    return answer;
}