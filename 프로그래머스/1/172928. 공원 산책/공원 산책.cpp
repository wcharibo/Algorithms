#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int row = park.size(), col = park[0].size();
    int c_row = 0, c_col = 0;
    
    for(int i=0; i<park.size(); i++){
        for(int j=0; j<park[i].size(); j++){
            if(park[i][j]=='S'){
                c_row = i, c_col = j;
                break;
            }
        }
    }
    
    for(int i = 0; i < routes.size(); i++){
        
        char dir = routes[i][0];
        int dist = routes[i][2] - '0';
        int flag = 1;
        
        if(dir=='E'){
            if(c_col + dist < col){
                for(int j=1; j<=dist; j++){
                    if(park[c_row][c_col+j] == 'X') flag = 0;
                }
                if(flag == 1){
                    c_col+=dist;
                }
            }
        }
        else if(dir=='W'){
            if(c_col - dist >= 0){
                for(int j=1; j<=dist; j++){
                    if(park[c_row][c_col-j] == 'X') flag = 0;
                }
                if(flag == 1){
                    c_col-=dist;
                }
            }
        }
        else if(dir=='S'){
            if(c_row + dist < row){
                for(int j=1; j<=dist; j++){
                    if(park[c_row+j][c_col] == 'X') flag = 0;
                }
                if(flag == 1){
                    c_row+=dist;
                }
            }
        }
        else{
            if(c_row - dist >= 0){
                for(int j=1; j<=dist; j++){
                    if(park[c_row - j][c_col] == 'X') flag = 0;
                }
                if(flag == 1){
                    c_row-=dist;
                }
            }
        }
    }
    
    answer.push_back(c_row);
    answer.push_back(c_col);
    
    return answer;
}