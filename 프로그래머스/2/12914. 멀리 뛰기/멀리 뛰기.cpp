#include <string>
#include <vector>

using namespace std;

long long solution(int n) {
    long long answer = 0;
    
    vector<long long> fib;
    fib.push_back(1);
    fib.push_back(2);
    
    for(int i = 2; i < n; i++){
        fib.push_back((fib[i-1]+fib[i-2])%1234567);
    }
    
    answer = fib[n-1];
    return answer;
}