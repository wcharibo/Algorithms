#include <string>
#include <vector>
#include <sstream>
#include <map>
#include <iostream>

using namespace std;

void cal(string order, int num, map<int,int> &min, map<int,int,greater<int>> &max){
    if(order == "I"){
        if(min.insert({num, 1}).second == false) min[num]++;
        if(max.insert({num, 1}).second == false) max[num]++;
    }
    else if(max.size()==0) return;
    else if(order == "D" && num == 1){//del max
        if(max.begin()->second > 1){
            max.begin()->second--;
            min[max.begin()->first]--;
            return;
        }
        min.erase(max.begin()->first);
        max.erase(max.begin());
    }
    else{//del min
        if(min.begin()->second > 1){
            min.begin()->second--;
            max[min.begin()->first]--;
            return;
        }
        max.erase(min.begin()->first);
        min.erase(min.begin());
    }
}

vector<int> solution(vector<string> operations) {
    vector<int> answer;
    map<int,int> min_map;
    map<int,int, greater<int>> max_map;
    
    for(string oprt : operations){
        string order;
        int num;
        istringstream iss(oprt);
        iss>>order>>num;
        cal(order, num, min_map, max_map);
    }
    answer.push_back(max_map.begin()->first);
    answer.push_back(min_map.begin()->first);
    
    return answer;
}