#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<int> topping) {
    int answer = 0;
    unordered_map<int, int> tops;
    vector<int> forward;
    vector<int> backward;
    for(int i = 0; i < topping.size(); i++){
        tops.insert({topping[i], 1});
        forward.push_back(tops.size());
    }
    tops.clear();
    for(int i = topping.size()-1; i >= 0; i--){
        tops.insert({topping[i], 1});
        backward.push_back(tops.size());
    }
    for(int i = 0; i< forward.size()-1; i++){
        if(forward[i]==backward[int(forward.size())-i-2]) answer++;
    }
    return answer;
}