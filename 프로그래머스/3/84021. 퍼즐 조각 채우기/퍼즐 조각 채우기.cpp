#include <string>
#include <vector>
#include <algorithm>

using namespace std;

void find(vector<vector<int>> &mat, vector<pair<int, int>> &block, int m, int n, int target){
    vector<int> x = {-1, 1, 0, 0}, y = {0, 0, 1, -1};
    target == 0 ? mat[m][n] = 1 : mat[m][n] = 0;
    block.push_back({m,n});
    
    for(int i = 0; i < 4; i++){
        int next_row = m+x[i], next_col = n+y[i];
        if(next_row < mat.size() && next_row >= 0 && next_col < mat.size() && next_col >= 0){
            if(mat[next_row][next_col] == target) find(mat, block, next_row, next_col, target);
        }
    }
}

void normalize(vector<pair<int, int>> &before){
    vector<pair<int, int>> result = before;
    before.clear();
    int min_x = 100, min_y = 100;
    
    for(pair<int, int> i : result){
        if(min_x > i.first) min_x = i.first;
        if(min_y > i.second) min_y = i.second;
    }
    
    for(pair<int, int> i: result) before.push_back({i.first-min_x, i.second-min_y});
    
    sort(before.begin(), before.end());
}

vector<pair<int,int>> rotate(vector<pair<int, int>> before){
    int max = 0;
    for(pair<int,int> i : before){
        if(i.first > max) max = i.first;
        if(i.second > max) max = i.second;
    }
    
    vector<pair<int, int>> after;
    
    for(pair<int, int> i : before) after.push_back({i.second, max-i.first});
    
    normalize(after);
    
    return after;
}

bool fit(vector<pair<int, int>> vac, vector<pair<int, int>> puz){
    vector<pair<int, int>> temp = puz;
    if(vac == temp) return true;
    
    for(int k = 0; k < 3; k++){
        temp = rotate(temp);
        if(vac == temp) return true;
    }
    
    return false;
    
}

int solution(vector<vector<int>> game_board, vector<vector<int>> table) {
    int answer = 0, size = game_board.size();
    vector<vector<pair<int, int>>> vacancy, puzzle;
    vector<vector<int>> test_game_board = game_board, test_table = table;
    
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            if(test_game_board[i][j] == 0){
                vector<pair<int, int>> temp;
                find(test_game_board, temp, i, j, 0);
                normalize(temp);
                vacancy.push_back(temp);
            }
            if(test_table[i][j] == 1){
                vector<pair<int, int>> temp;
                find(test_table, temp, i, j, 1);
                normalize(temp);
                puzzle.push_back(temp);
            }
        }
    }
    
    vector<int> filled(vacancy.size(), 0);
    vector<int> used(puzzle.size(), 0);
    
    for(int i = 0; i < vacancy.size(); i++){
        for(int j = 0; j < puzzle.size(); j++){
            if(filled[i] != 1 && used[j] != 1 && fit(vacancy[i], puzzle[j])){
                filled[i] = 1;
                used[j] = 1;
                answer+=vacancy[i].size();
            }
        }
    }
    
    return answer;
}