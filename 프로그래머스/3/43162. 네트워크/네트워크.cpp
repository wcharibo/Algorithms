#include <string>
#include <vector>

using namespace std;

int answer = 0;

void dfs(vector<vector<int>> &com_table, int x, int y);

int solution(int n, vector<vector<int>> computers) {
    
    for(int i = 0; i < computers.size(); i++){
        int flag = 0;
        for(int j = 0; j < computers[i].size(); j++){
            if(flag !=0 && i != j && computers[i][j] == 1){
                dfs(computers, i, j);
            }
            else if(i != j && computers[i][j] == 1){
                flag = 1;
                answer++;
                dfs(computers, i, j);
            }
        }
        if(computers[i][i] !=0 && flag ==0) answer++;
    }
    return answer;
}

void dfs(vector<vector<int>> &com_table, int x, int y){
    com_table[x][y] = 0;
    com_table[y][x] = 0;
    com_table[y][y] = 0;
    for(int k = 0; k < com_table[y].size(); k++){
        if(com_table[y][k]==1){
            dfs(com_table, y, k);
        }
    }
}