#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    int start = 0, target = number.size() - k;
    
    for(int i = target; i > 0; i--){
        int max = 0;
        for(int j = start; j <= number.size() - i; j++){
            if(number[j] > max){
                max = number[j];
                start = j+1;
            }
        }
        answer+=max;
    }
    
    return answer;
}