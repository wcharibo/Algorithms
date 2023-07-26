#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector <vector<vector <int> > > tmtMat;
int tmtArr, tmtCol, tmtStair, result;
void ripe();
queue <pair <int, pair <int, pair<int, int> > > > q;
pair<int, pair<int, pair<int, int> > > temp;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    cin>>tmtCol>>tmtArr>>tmtStair;
    tmtMat.resize(tmtStair, vector <vector <int> >(tmtArr, vector <int>(tmtCol, 0)));
    for(int i = 0; i< tmtStair;i++){
        for(int j = 0; j<tmtArr;j++){
            for(int k=0; k<tmtCol; k++){
                cin>>tmtMat[i][j][k];
                if(tmtMat[i][j][k]==1) q.emplace(make_pair(0 ,make_pair(i, make_pair(j,k))));
            }
        }
    }
    int flag=1;
    for(int i = 0; i< tmtStair;i++){
        for(int j = 0; j<tmtArr;j++){
            for(int k=0; k<tmtCol; k++){
                if(tmtMat[i][j][k]==0) {
                    flag=0;
                    break;
                }
            }
            if(flag==0) break;
        }
        if(flag==0) break;
    }
    
    if(flag==1){
        cout<<0;
        return 0;
    }
    
    if(q.empty()){
        result = -1;
        cout<<result;
        return 0 ;
    }
    
    ripe();
    
    cout<<result;
}

void ripe(){
    temp = q.front();
    q.pop();
    
    int a = temp.first+1;
    if(temp.second.second.first-1 >= 0 && tmtMat[temp.second.first][temp.second.second.first-1][temp.second.second.second]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first, make_pair(temp.second.second.first-1,temp.second.second.second))));
        tmtMat[temp.second.first][temp.second.second.first-1][temp.second.second.second]=1;
    }
    if(temp.second.second.second-1 >= 0 && tmtMat[temp.second.first][temp.second.second.first][temp.second.second.second-1]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first, make_pair(temp.second.second.first,temp.second.second.second-1))));
        tmtMat[temp.second.first][temp.second.second.first][temp.second.second.second-1]=1;
    }
    if(temp.second.second.first+1 < tmtArr && tmtMat[temp.second.first][temp.second.second.first+1][temp.second.second.second]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first, make_pair(temp.second.second.first+1,temp.second.second.second))));
        tmtMat[temp.second.first][temp.second.second.first+1][temp.second.second.second]=1;
    }
    if(temp.second.second.second+1 < tmtCol && tmtMat[temp.second.first][temp.second.second.first][temp.second.second.second+1]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first, make_pair(temp.second.second.first,temp.second.second.second+1))));
        tmtMat[temp.second.first][temp.second.second.first][temp.second.second.second+1]=1;
    }
    if(temp.second.first-1 >= 0 && tmtMat[temp.second.first-1][temp.second.second.first][temp.second.second.second]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first-1, make_pair(temp.second.second.first,temp.second.second.second))));
        tmtMat[temp.second.first-1][temp.second.second.first][temp.second.second.second]=1;
    }
    if(temp.second.first+1 < tmtStair && tmtMat[temp.second.first+1][temp.second.second.first][temp.second.second.second]==0){
        q.emplace(make_pair(a, make_pair(temp.second.first+1, make_pair(temp.second.second.first,temp.second.second.second))));
        tmtMat[temp.second.first+1][temp.second.second.first][temp.second.second.second]=1;
    }
    
    if(q.empty()){
        int flag=1;
        for(int i=0; i<tmtStair; i++){
            for(int j=0; j<tmtArr; j++){
                for(int k=0; k<tmtCol; k++){
                    if(tmtMat[i][j][k]==0) {
                    flag=0;
                    result = -1;
                    return;
                    }
                }
            }
        }
        if(flag==1){
            result = temp.first;
            return;
        }
    }
    ripe();
}