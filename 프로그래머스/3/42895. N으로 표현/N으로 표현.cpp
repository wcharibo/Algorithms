#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(int N, int number) {
    int answer = -1, cnt = 1;
    vector<unordered_set<int>> arr(9);
    
    arr[0].insert(0);
    for(int i = 1; i < arr.size(); i++){
        int temp = (*arr[i-1].begin())*10+N;
        if(temp == number) return i;
        else arr[i].insert(temp);
    }
    
    while(cnt < 9){
        for(int i = cnt - 1; i >= cnt - i; i--){
            for(auto j = arr[i].begin(); j != arr[i].end(); j++){
                for(auto k = arr[cnt - i].begin(); k != arr[cnt - i].end(); k++){
                    vector<int> temp(6);
                    temp[0] = *j + *k;
                    temp[1] = *j - *k;
                    temp[2] = *j / *k;
                    temp[3] = *j * *k;
                    temp[4] = *k - *j;
                    temp[5] = *k / *j;
                    
                    for(int t : temp){
                        if(t == number) return cnt;
                        else if(t > 0 ){
                            arr[cnt].insert(t);
                        }
                    }
                }
            }
        }
        
        cnt++;
        
    }

    
    return answer;
}