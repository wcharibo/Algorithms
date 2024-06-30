#include <string>
#include <vector>

using namespace std;

/*
전체 행렬을 2중 for문으로 탐색하면서 left_end, top, right_end, bottom을 기록한다. 이후에 right_end, bottom은 +1을 해주고 answer에 입력하고 반환
*/

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    
    int h_max = wallpaper[0].size(), v_max = wallpaper.size();
    
    for(int i=0; i< v_max; i++){
        for(int j=0; j<h_max; j++){
            if(wallpaper[i][j]=='#'){
                if(answer.size()==0){
                    answer.resize(4,0);
                    answer={i,j,i,j};
                }
                if(i<answer[0]) answer[0]=i;
                else if(i>answer[2]) answer[2]=i;
                if(j<answer[1]) answer[1]=j;
                else if(j>answer[3]) answer[3]=j;
            }
        }
    }
    
    answer = {answer[0], answer[1], answer[2]+1, answer[3]+1};
    return answer;
}