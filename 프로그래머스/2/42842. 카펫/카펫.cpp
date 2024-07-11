#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    int i = 1;
    while(1){
        if(yellow%i==0 && (yellow/i+i+2)*2==brown){
            answer.push_back(max(yellow/i+2, i+2));
            answer.push_back(min(yellow/i+2, i+2));
            break;
        }
        i++;
    }
    return answer;
}