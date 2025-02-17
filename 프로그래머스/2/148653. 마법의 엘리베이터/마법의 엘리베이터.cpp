#include <string>

using namespace std;

int solution(int storey) {
    int answer = 0, remain = 0;

    while(storey > 0){
        remain = storey%10;
        storey = storey/10;
        
        if(remain == 5 && storey != 0){
            if(storey%10 >= 5) storey++;
            answer+=remain;
        }
        else if(remain <=5) answer+=remain;
        else{
            answer+=(10-remain);
            storey++;
        }
    }
    
    return answer;
}