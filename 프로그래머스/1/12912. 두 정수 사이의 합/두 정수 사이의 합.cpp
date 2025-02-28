#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    int max1 = max(a, b);
    int min1 = min(a, b);
    for(long long i = min1; i <= max1; i++) answer+=i;
    return answer;
}