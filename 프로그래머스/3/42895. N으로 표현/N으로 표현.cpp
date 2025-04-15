#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

int solution(int N, int number) {
    int answer = -1, cnt = 1;
    vector<unordered_set<int>> arr(9);
    
    int number_form = 0;
    arr[0].insert(number_form);
    for(int i = 1; i < arr.size(); i++){
        number_form = number_form*10+N;
        if(number_form == number) return i;
        else arr[i].insert(number_form);
    }
    
    while(cnt < 9){
        for(int i = cnt - 1; i >= cnt - i; i--){
            for(auto j : arr[i]){
                for(auto k : arr[cnt - i]){
                    vector<int> temp(6);
                    temp[0] = j + k;
                    temp[1] = j - k;
                    temp[2] = j / k;
                    temp[3] = j * k;
                    temp[4] = k - j;
                    temp[5] = k / j;
                    
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