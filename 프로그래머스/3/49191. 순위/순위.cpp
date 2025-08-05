#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;


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