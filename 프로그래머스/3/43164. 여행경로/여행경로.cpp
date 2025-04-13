#include <string>
#include <vector>

using namespace std;

void dfs(int cur, const vector<vector<string>> tickets, vector<int> visited, vector<int> route, vector<vector<int>> &arrived){
    visited[cur] = 1;
    route.push_back(cur);
    
    if(route.size() == tickets.size()) arrived.push_back(route);
    else{
        for(int i = 0; i<tickets.size(); i++){
            if(visited[i] == 0 && tickets[cur][1] == tickets[i][0]) dfs(i, tickets, visited, route, arrived);
        }
    }
    
}

vector<string> solution(vector<vector<string>> tickets) {
    vector<string> answer(1, "Z");
    vector<int> start_airport;
    vector<vector<int>> arrived;
    
    for(int i = 0; i<tickets.size(); i++) if(tickets[i][0] == "ICN") start_airport.push_back(i);
    
    for(int i : start_airport){
        vector<int> visited(tickets.size(), 0);
        vector<int> route;
        
        dfs(i, tickets, visited, route, arrived);
    }
    
    for(vector<int> i : arrived){
        vector<string> temp(1, "ICN");
        for(int j : i){
            temp.push_back(tickets[j][1]);
        }
        if(temp < answer) answer = temp;
    } 
    
    return answer;
}