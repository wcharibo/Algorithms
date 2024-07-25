#include <string>
#include <vector>
#include <deque>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    deque<int> pro, pro_speed;
    
    for(int i = 0; i< progresses.size(); i++){
        pro.push_back(progresses[i]);
        pro_speed.push_back(speeds[i]);
    }
    
    while(pro.size()!=0){
        int temp = 0;
        if(pro[0]>=100){
            pro.pop_front();
            pro_speed.pop_front();
            temp++;
            while(pro.size()!=0 && pro[0]>=100){
                pro.pop_front();
                pro_speed.pop_front();
                temp++;
            }
        }
        if(temp!=0) answer.push_back(temp);
        for(int i = 0; i < pro.size(); i++) pro[i]+=pro_speed[i];
    }
    return answer;
}