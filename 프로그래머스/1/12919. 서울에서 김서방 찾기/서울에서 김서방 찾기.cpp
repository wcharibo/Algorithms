#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "";
    int temp;
    
    for(int i = 0; i < seoul.size(); i++){
        if(seoul[i] == "Kim") {
            temp = i;
            break;
        }
    }
    
    answer += "김서방은 ";
    answer += to_string(temp);
    answer +="에 있다";
    
    return answer;
}