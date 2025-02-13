#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    vector<pair<char, int>> numbs, result;
    int start = 0, target = number.size() - k;
    
    for(int i = 0; i < number.size(); i++) numbs.push_back({number[i], 1});
    
    for(int i = target; i > 0; i--){
        pair<char, int> max = {0,0};
        for(int j = start; j <= number.size() - i; j++){
            if(numbs[j].second && number[j] > max.first) max = {number[j], j}; 
        }
        answer+=max.first;
        start = max.second+1;
        numbs[max.second].second = -1;
    }
    
    return answer;
}