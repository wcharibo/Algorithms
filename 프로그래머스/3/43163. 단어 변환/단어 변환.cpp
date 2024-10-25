#include <string>
#include <vector>
#include <numeric>
#include <algorithm>

using namespace std;

int cal(string a, string b){
    int dist = 0;
    for(int i = 0; i < a.size(); i++){
        if(a[i]!=b[i]) dist++;
    }
    
    return dist;
}

void dfs(string anchor, string target, const vector<string> &words, vector<int> visited, vector<int> &vec_answer, int result){
    if(reduce(visited.begin(), visited.end()) == visited.size()) return;
    if(anchor == target) vec_answer.push_back(result);
    
    for(int i = 0; i<words.size(); i++){
        if(visited[i]==0) {
            int dist = cal(anchor, words[i]);
            if(dist == 0) visited[i] = 1;
            else if(dist == 1) dfs(words[i], target, words, visited, vec_answer, result+1);
        }
    }
}

int solution(string begin, string target, vector<string> words) {
    int answer = 0, flag = 0;
    vector <int> visited(words.size(), 0);
    vector <int> vec_answer;
    
    for(string i : words) if(target == i) flag = 1;
    if(flag==0) return answer;
    
    dfs(begin, target, words, visited, vec_answer, 0);
    
    if(vec_answer.size() == 0) return answer;
    
    answer = *min_element(vec_answer.begin(), vec_answer.end());
    
    return answer;
}