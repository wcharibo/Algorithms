#include <string>
#include <vector>
#include <numeric>
#include <queue>
#include <iostream>

using namespace std;

void dfs(int current, vector<vector<string>> tickets, vector<int> traveled, vector<int> vis, vector<vector<int>> &complete){
    vis[current] = 1;
    traveled.push_back(current);
    
    if(traveled.size() == tickets.size()){
        complete.push_back(traveled);
    }
    else{
        for(int i = 0; i < tickets.size(); i++){
            if(vis[i] == 0 && tickets[i][0] == tickets[traveled.back()].back()){
                dfs(i, tickets, traveled, vis, complete);
            }
        }
        
    }
    
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer;
    vector<int> start;
    vector<vector<int>> complete; 
    vector<int> traveled;
    
    for(int i = 0; i < tickets.size(); i++){
        if(tickets[i][0] == "ICN") start.push_back(i);
    }
    
    for(int i : start){
        vector<int> visited(tickets.size(), 0);
        
        dfs(i, tickets, traveled, visited, complete);
    }
    
    for(vector<int> i : complete){
        vector<string> temp;
        for(int j : i){
            temp.push_back(tickets[j][1]);
        }
        if(answer.empty()) answer = temp;
        else{
            if(temp < answer) answer = temp;
        }
    }
    
    answer.insert(answer.begin(), "ICN");
    
    return answer;
}