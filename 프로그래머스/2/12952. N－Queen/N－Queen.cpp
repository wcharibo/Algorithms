#include <string>
#include <vector>

using namespace std;

int cal(vector<int> result, int c){
    int n = result.size();
    
    for(int j = 0; j < c; j++){
        if(abs(c-j)==abs(result[c]-result[j])) return 0;
    }
    
    return 1;
}

int locate(vector<int> a, int c, vector<int> v){
    int temp = 0, n = a.size();
    
    if(c+1 == n){
        for(int i = 0; i < n; i++) if(v[i] == 0 && abs(i - a[c-1]) >1) {a[c] = i; return cal(a, c);}
    }
    else{
        for(int i = 0; i<n; i++){
            if(abs(i - a[c-1]) >1 && v[i] != 1){
                a[c] = i;
                v[i] = 1;
                if(cal(a, c)) temp+=locate(a, c+1, v);
            
                v[i] = 0;
            }
        }
    }
    
    return temp;
}

int solution(int n) {
    int answer = 0;
    if(n == 1) return 1;
    
    for(int i = 0; i < n; i++){
        vector<int> board(n, -1);
        vector<int> visited(n, 0);
        
        board[0] = i;
        visited[i] = 1;
        answer+=locate(board, 1, visited);
    }
    
    return answer;
}