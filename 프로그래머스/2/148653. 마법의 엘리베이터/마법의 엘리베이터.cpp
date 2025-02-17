#include <string>

using namespace std;

int solution(int storey) {
    int answer = 0, remain = 0;

    while(storey > 0){
        remain = storey%10;
        storey = storey/10;
        
        if(remain > 5 || (remain == 5 && storey%10 >= 5)){
            storey++;
            answer+=(10-remain);
        }
        else answer+=remain;
    }
    
    return answer;
}