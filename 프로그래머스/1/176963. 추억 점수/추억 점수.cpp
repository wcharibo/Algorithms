#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;
    unordered_map<string, int> mem_score;
    
    for(int i=0; i<name.size(); i++){
        mem_score.insert({name[i], yearning[i]});
    }
    
    for(int i=0; i<photo.size(); i++){
        answer.push_back(0);
        for(int j=0; j<photo[i].size(); j++){
            auto score = mem_score.find(photo[i][j]);
            if(score!=mem_score.end()){
                answer[i]+=score->second;
            }
        }
    }
    return answer;
}