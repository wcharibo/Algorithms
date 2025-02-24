#include <string>
#include <vector>
#include <numeric>


using namespace std;

int solution(vector<int> arrayA, vector<int> arrayB) {
    int answer = 0, resA = arrayA.front(), resB = arrayB.front();
    int flag = 0;
    
    for(int i : arrayA) resA = gcd(resA, i);
    for(int i : arrayB) {
        if(i%resA == 0) flag = 1;
        resB = gcd(resB, i);
    }
    
    if(flag == 1){
        for(int i : arrayA) if(i%resB==0) return answer;
    }
    
    answer = max(resA, resB);
    

    return answer;
}