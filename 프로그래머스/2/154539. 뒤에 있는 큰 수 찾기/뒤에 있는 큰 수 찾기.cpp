#include <string>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer(numbers.size(), 0);
    stack<pair<int, int>> num_stack;
    num_stack.push({numbers[0], 0});
    
    for(int i = 1; i < numbers.size(); i++){
        while(num_stack.size()!=0 && numbers[i]>num_stack.top().first){
            answer[num_stack.top().second] = numbers[i];
            num_stack.pop();
        }
        num_stack.push({numbers[i], i});
    }
    while(num_stack.size()!=0){
        answer[num_stack.top().second] = -1;
        num_stack.pop();
    }
    return answer;
}