#include <string>
#include <vector>
#include <sstream>
#include <iostream>

using namespace std;

vector<int> solution(long long n) {
    vector<int> answer;
    
    stringstream s;
    s<<n;
    
    for(auto iter = s.str().rbegin(); iter != s.str().rend(); iter++) answer.push_back((*iter)-48);
    return answer;
}