#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<long long> fib={0,1};
    for(int i = 2; i<=n; i++){
        fib.push_back((fib[i-2]%1234567)+(fib[i-1]%1234567));
    }
    answer = fib[n]%1234567;
    return answer;
}