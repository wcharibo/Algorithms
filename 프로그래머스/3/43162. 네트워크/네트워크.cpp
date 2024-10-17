#include <string>
#include <vector>

using namespace std;

void dfs(vector<vector<int>> com_table, vector<int> &visited, int i){
    for(int k = 0; k < com_table[i].size(); k++){
        if(com_table[i][k]==1 && visited[k] != 1 && i != k){
            visited[k] = 1;
            dfs(com_table, visited, k);
        }
    }
}

int solution(int n, vector<vector<int>> computers) {
    int answer = 0;
    vector<int> visited(n, 0);
    
    for(int i = 0; i < n; i++){
        if(visited[i] == 1) continue;
        
        visited[i] = 1;
        answer++;
        
        dfs(computers, visited, i);
    }
    return answer;
}