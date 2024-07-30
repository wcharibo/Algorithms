#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size(),0);
    for(int i = 0; i < prices.size()-1; i++){
        int cur_price = prices[i];
        for(int j = i+1; j < prices.size(); j++){
            if(cur_price > prices[j]){
                answer[i] = j-i;
                break;
            }
            answer[i] = j-i;
        }
    }
    return answer;
}