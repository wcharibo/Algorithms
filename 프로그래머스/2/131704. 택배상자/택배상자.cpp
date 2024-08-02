#include <string>
#include <vector>
#include <stack>
#include <iostream>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> sub_con;
    sub_con.push(0);
    int i = 0, j = 0;
    while(i<=order.size() && j<order.size()){
        if(order[j] == i+1){
            j++;
            i++;
            answer++;
        }
        else if(order[j] == sub_con.top()){
            j++;
            answer++;
            sub_con.pop();    
        }
        else{
            sub_con.push(i+1);
            i++;
        }
    }
    return answer;
}