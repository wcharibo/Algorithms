#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string my_string, int n) {
    string answer = "";
    for(int i=0; i<n; i++){
        string temp = string(1, my_string[i]);
        answer.append(temp);
    }
    return answer;
}