#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int N, int number) {
    int answer = -1, cnt = 1;
    vector<vector<int>> arr(9);
    
    arr[0].push_back(0);
    for(int i = 1; i < arr.size(); i++){
        int temp = arr[i-1][0]*10+N;
        if(temp == number) return i;
        else arr[i].push_back(temp);
    }
    
    while(cnt < 9){
        for(int i = cnt - 1; i >= cnt - i; i--){
            for(int j = 0; j < arr[i].size(); j++){
                for(int k = 0; k < arr[cnt - i].size(); k++){
                    vector<int> temp(6);
                    temp[0] = arr[i][j] + arr[cnt - i][k];
                    temp[1] = arr[i][j] - arr[cnt - i][k];
                    temp[2] = arr[i][j] / arr[cnt - i][k];
                    temp[3] = arr[i][j] * arr[cnt - i][k];
                    temp[4] = arr[cnt - i][k] - arr[i][j];
                    temp[5] = arr[cnt - i][k] / arr[i][j];
                    
                    for(int t : temp){
                        if(t == number) return cnt;
                        else if(t > 0 ){
                            arr[cnt].push_back(t);
                        }
                    }
                }
            }
        }
        
        cnt++;
        
    }

    
    return answer;
}