#include <iostream>
#include <vector>

using namespace std;

int answer;

bool check_pos(vector<int> board, int last){
    for(int i = 0; i < last; i++){
        if(last-i == abs(board[i] - board[last])) return false;
    }
    
    return true;
}

void dfs(vector<int> board, vector<bool> visited, int max){
    int last = board.back();
    
    if(board.size() == max) answer++;
    else{
        for(int i = 0; i < max; i++){
            if(!visited[i] && abs(last- i)>1){
                board.push_back(i);
                visited[i] = true;
                if(check_pos(board, board.size() -1)) dfs(board, visited, max);
                
                board.pop_back();
                visited[i] = false;
            } 
        }
    }
    
}

int main(void)
{
	int board_size;
	
	cin>>board_size;
	
	for(size_t start = 0; start < board_size; start++){
	    vector<int> board;
	    vector<bool> visited(board_size, false);
	    
	    board.push_back(start);
	    visited[start] = true;
	    
	    dfs(board, visited, board_size);
	}
	
	cout<<answer;
}