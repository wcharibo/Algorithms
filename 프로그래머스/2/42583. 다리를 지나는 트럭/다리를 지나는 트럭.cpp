#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0, now = 0;
    queue <pair<int, int>> on_bridge;
    int cnt = 0;
    while(1){
        answer++;
        if(!on_bridge.empty() && answer - on_bridge.front().second >= bridge_length){
            now-=on_bridge.front().first;
            on_bridge.pop();
        }
        if(now + truck_weights[cnt] <= weight){
            on_bridge.push({truck_weights[cnt], answer});
            now += truck_weights[cnt];
            cnt++;
        }
        else{
            answer=on_bridge.front().second + bridge_length - 1;
        } 
        cout<<"now: "<<now<<", answer: "<< answer<<endl;
        if(cnt == size(truck_weights)) {answer+=bridge_length; break;}
    }
    return answer;
}