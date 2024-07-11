#include <string>
#include <vector>
#include <cmath>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    vector<pair<int, int>> pos_table;
    
    for(int i = 1; i<= sqrt(yellow); i++){
        if(yellow%i==0) pos_table.push_back({yellow/i, i});
    }
    
    for(pair<int, int> a : pos_table){
        int temp = (a.first+2+a.second)*2;
        if(temp == brown){
            answer.push_back(max(a.first+2, a.second+2));
            answer.push_back(min(a.first+2, a.second+2));
            break;
        }
    }
    
    return answer;
}