#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>

using namespace std;

bool ord(char a, char b){return a>b;}

long long solution(long long n) {
    long long answer = 0;
    
    stringstream s;
    s<<n;
    
    string str = s.str();
    
    sort(str.begin(), str.end(), ord);
    
    answer = stoll(str);
    
    return answer;
}