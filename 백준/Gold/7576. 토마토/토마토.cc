#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector <vector<int> > tmtMat;
int tmtArr, tmtCol, result;
void ripe();
pair <int, int>  temp;
queue <pair <int, int> > q;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    cin>>tmtCol>>tmtArr;
    tmtMat.resize(tmtArr, vector <int>(tmtCol, 0));
    for(int i = 0; i< tmtArr;i++){
        for(int j = 0; j<tmtCol;j++){
            cin>>tmtMat[i][j];
            if(tmtMat[i][j]==1) q.emplace(make_pair(i,j));
        }
    }
    int flag=1;
    for(int i = 0; i< tmtArr;i++){
        for(int j = 0; j<tmtCol;j++){
            if(tmtMat[i][j]==0){
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
        cout<< result;
        return 0;
    }
    
    ripe();
    
    cout<<result;
}

void ripe(){
    temp = q.front();
    q.pop();
    
    int a = tmtMat[temp.first][temp.second]+1;
    if(temp.first-1 >= 0 && tmtMat[temp.first-1][temp.second]==0){
        q.emplace(make_pair(temp.first-1,temp.second));
        tmtMat[temp.first-1][temp.second]=a;
    }
    if(temp.second-1 >= 0 && tmtMat[temp.first][temp.second-1]==0){
        q.emplace(make_pair(temp.first,temp.second-1));
        tmtMat[temp.first][temp.second-1]=a;
    }
    if(temp.first+1 < tmtArr && tmtMat[temp.first+1][temp.second]==0){
        q.emplace(make_pair(temp.first+1,temp.second));
        tmtMat[temp.first+1][temp.second]=a;
    }
    if(temp.second+1 < tmtCol && tmtMat[temp.first][temp.second+1]==0){
        q.emplace(make_pair(temp.first,temp.second+1));
        tmtMat[temp.first][temp.second+1]=a;
    }
    
    if(q.empty()){
        
        int flag=1;
        for(int i=0; i<tmtArr; i++){
            for(int j=0; j<tmtCol; j++){
                if(tmtMat[i][j]==0) {
                    flag=0;
                    result = -1;
                    return;
                }
            }
        }
        
        if(flag==1){
            result = tmtMat[temp.first][temp.second]-1;
            return;
        
    }
        
    
        
    }
    
    ripe();
}