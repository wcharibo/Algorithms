#include <iostream>
#include <vector>

using namespace std;

void dfs(vector< vector <int> > &arr,int x, int y);

int main(){
    int case_num, x, y;
    cin>>case_num;
    vector <int> cnt(case_num, 0);
    vector< vector <int> > farm_mat(case_num, vector<int>(3,0));
    for(int i=0; i<case_num; i++){
        cin>>farm_mat[i][0]>>farm_mat[i][1]>>farm_mat[i][2];
        vector< vector <int> > lettuce_mat(farm_mat[i][0]+2, vector <int>(farm_mat[i][1]+2, 0));
        for(int j=0; j<farm_mat[i][2];j++){
            cin>>x>>y;
            lettuce_mat[x+1][y+1]=1;
        }
        for(int m=1; m<=farm_mat[i][0]; m++){
            for(int n=1; n<=farm_mat[i][1]; n++){
                if(lettuce_mat[m][n]==1){
                    cnt[i]++;
                    dfs(lettuce_mat, m, n);
                }
            }
        }
    }
    for(int i =0;i<case_num;i++){
        cout<<cnt[i]<<endl;
    }
}

void dfs(vector< vector <int> > &arr, int x, int y){
    arr[x][y]=0;
    if(arr[x][y+1]==1) dfs(arr, x, y+1);
    if(arr[x+1][y]==1) dfs(arr, x+1, y);
    if(arr[x][y-1]==1) dfs(arr, x, y-1);
    if(arr[x-1][y]==1) dfs(arr, x-1, y);
}