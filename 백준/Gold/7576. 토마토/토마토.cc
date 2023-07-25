#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector <vector<int> > tmtMat;
int tmtArr, tmtCol, result;
void ripe();
queue <pair <int, pair <int, int> > > q;
pair <int, pair <int, int> > temp;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector <pair <int,int> > ripeTmt;
    cin>>tmtCol>>tmtArr;
    tmtMat.resize(tmtArr, vector <int>(tmtCol, 0));
    for(int i = 0; i< tmtArr;i++){
        for(int j = 0; j<tmtCol;j++){
            cin>>tmtMat[i][j];
            if(tmtMat[i][j]==1) q.emplace(make_pair(0, make_pair(i,j)));
        }
    }
    int flag=1;
    for(int i=0; i<tmtArr; i++){
            for(int j=0; j<tmtCol; j++){
                if(tmtMat[i][j]==0) {
                    flag=0;
                    break;
                }
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
    if(temp.second.first-1 >= 0 && tmtMat[temp.second.first-1][temp.second.second]==0){
        q.push(make_pair(a, make_pair(temp.second.first-1,temp.second.second)));
        tmtMat[temp.second.first-1][temp.second.second]=1;
    }
    if(temp.second.second-1 >= 0 && tmtMat[temp.second.first][temp.second.second-1]==0){
        q.push(make_pair(a, make_pair(temp.second.first,temp.second.second-1)));
        tmtMat[temp.second.first][temp.second.second-1]=1;
    }
    if(temp.second.first+1 < tmtArr && tmtMat[temp.second.first+1][temp.second.second]==0){
        q.push(make_pair(a, make_pair(temp.second.first+1,temp.second.second)));
        tmtMat[temp.second.first+1][temp.second.second]=1;
    }
    if(temp.second.second+1 < tmtCol && tmtMat[temp.second.first][temp.second.second+1]==0){
        q.push(make_pair(a, make_pair(temp.second.first,temp.second.second+1)));
        tmtMat[temp.second.first][temp.second.second+1]=1;
    }
    
    if(q.empty()){
        result = -1;
        return;
    }
    
    if(temp.first!=q.front().first){
        int flag=1;
        for(int i=0; i<tmtArr; i++){
            for(int j=0; j<tmtCol; j++){
                if(tmtMat[i][j]==0) {
                    flag=0;
                    break;
                }
            }
            if(flag==0) break;
        }
        
        if(flag==1){
            result = temp.first+1;
            return;
        }
    }
    
    ripe();
}