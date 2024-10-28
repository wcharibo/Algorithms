#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map <string, int> marathon;
    
    for(string person : participant) if(marathon.insert({person, 1}).second == false) marathon[person]++;
    for(string complete : completion) marathon[complete]--;
    for(auto iter = marathon.begin(); iter != marathon.end(); iter++) if(iter->second != 0) answer=iter->first;
    
    return answer;
}