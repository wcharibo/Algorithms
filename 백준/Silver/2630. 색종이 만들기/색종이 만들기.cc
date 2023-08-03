#include <iostream>
#include <vector>

using namespace std;

int whiteCnt, blueCnt;
vector <vector <int> > paper;

void cal(pair<int, int> x, int w);

int main() {
    int width;
    cin>>width;
    paper.resize(width, vector <int>(width, 0));
    
    for(int i=0; i<width; i++){
        for(int j=0; j<width; j++){
            cin>>paper[i][j];
        }
    }
    
    cal(make_pair(0,0), width);
    
    cout<<whiteCnt<<'\n';
    cout<<blueCnt;
}

void cal(pair<int, int> x, int w){
    int temp = 0, answer = w*w;
    for(int i = 0; i<w; i++){
        for(int j=0; j<w; j++){
            if(paper[x.first + i][x.second + j]==1) temp++;
        }
    }
    if(temp==answer) blueCnt++;
    else if(temp==0) whiteCnt++;
    else{
        cal(make_pair(x.first, x.second), w/2);
        cal(make_pair(x.first, x.second + w/2), w/2);
        cal(make_pair(x.first + w/2, x.second), w/2);
        cal(make_pair(x.first + w/2, x.second + w/2), w/2);
    }
}