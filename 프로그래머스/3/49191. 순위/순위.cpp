#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

// int check_graph(int i, vector<vector<int>> results, vector<int> vis, int &flag, int n){
//     vis[results[i][0]] = 1;
    
//     if(vis.size() == n) flag = 1;
//     else if(flag==0){
//         for(int j = 0; j < results.size(); j++){
//             if(vis[j] == 0 && results[j][0] == results[i][1]){
//                 flag = check_graph(j, results, vis, flag, n);
//             }
//         }
//     }
    
//     return flag;
// }

// int solution(int n, vector<vector<int>> results) {
//     int answer = 0, pos = 0;
//     vector<vector<int>> match(n);
//     vector<int> visited(n, 0);
    
//     pos = check_graph(0, results, visited, pos, n);
    
//     if(pos == 1){
//         for(vector<int> i : results) match[i[0]-1].push_back(i[1]-1);
//     }
//     else return answer;
  
//     return answer;
// }

int solution(int n, vector<vector<int>> results){
    int answer = 0;
    vector<vector<int>> match(n+1, vector<int> (n+1, 100000000));
    for(int i = 1; i < n+1; i++) match[i][i] = 0;
    
    for(vector<int> i : results){
        match[i[0]][i[1]] = 1;
        match[i[1]][i[0]] = -1;
    }
    
    for(int i = 1; i < n+1; i++){
        for(int j = 1; j < n+1; j++){
            for(int k = 1; k < n+1; k++){
                if(j != i && k != i && j!=k){
                    int temp = match[j][i] + match[i][k];
                    if(abs(temp) == 2){
                        match[j][k] = match[j][i];
                    }
                }
            }
        }
    }
    
    for(int i = 1; i<n+1; i++){
        int flag = 0;
        for(int j = 1; j<n+1; j++){
            if(i != j && abs(match[i][j]) > 2) flag = 1;
        }
        if(flag == 0) answer++;
    }
    
    return answer;
}