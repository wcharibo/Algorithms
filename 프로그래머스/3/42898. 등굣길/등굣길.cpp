#include <string>
#include <vector>

using namespace std;

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    vector<vector<int>> way_to_home(m, vector<int> (n,0));
    
    for(vector<int> i : puddles) way_to_home[i[0]-1][i[1]-1] = -1;
    
    way_to_home[0][0] = 1;
    
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(way_to_home[i][j]<0) continue;
            if(i!=0 && j!=0){
                if(way_to_home[i-1][j]>0) way_to_home[i][j]+=way_to_home[i-1][j]%1000000007;
                if(way_to_home[i][j-1]>0) way_to_home[i][j]+=way_to_home[i][j-1]%1000000007;
            }
            else if(j == 0 && i!=0 && way_to_home[i-1][j]>0) way_to_home[i][j] = way_to_home[i-1][j]%1000000007;
            else if(i == 0 && j!=0 && way_to_home[i][j-1]>0)way_to_home[i][j] = way_to_home[i][j-1]%1000000007;
        }
    }
    
    return way_to_home[m-1][n-1]%1000000007;
}