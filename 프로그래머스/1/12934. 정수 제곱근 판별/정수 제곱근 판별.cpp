#include <string>
#include <vector>

using namespace std;

long long solution(long long n) {
    long long answer = -1;
    
    for(long long i = 1; i <= n; i++){
        long long de = n/i;
        long long re = n%i;
        if(de == i && re == 0 ) return (i+1)*(i+1);
    }
    
    return answer;
}