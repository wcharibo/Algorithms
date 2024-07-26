#include <string>
#include <vector>
#include <deque>
#include <algorithm>

using namespace std;

int solution(vector<int> priorities, int location) {
    int answer = 0;
    deque<int> pri_que;
    deque<pair<int, int>> que;
    
    for(int i = 0; i < priorities.size(); i++){
        pri_que.push_back(priorities[i]);
        que.push_back({priorities[i], i});
    }
    
    sort(pri_que.rbegin(), pri_que.rend());
    
    while(pri_que.size()){
        if(que.front().first < pri_que.front()){
            que.push_back(que.front());
            que.pop_front();
        }
        else{
            if(que.front().second==location){
                answer++;
                return answer;
            }
            que.pop_front();
            pri_que.pop_front();
            answer++;
        }
    }
    return answer;
}