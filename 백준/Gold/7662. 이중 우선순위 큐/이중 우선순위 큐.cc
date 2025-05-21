#include <string>
#include <vector>
#include <map>
#include <iostream>

using namespace std;
map<int,int> min_map;
map<int,int,greater<int>> max_map;

void cal(string order, int num){
    if(order == "I"){
        if(min_map.insert({num, 1}).second == false) min_map[num]++;
        if(max_map.insert({num, 1}).second == false) max_map[num]++;
    }
    else if(max_map.size()==0) return;
    else if(order == "D" && num == 1){//del max
        if(max_map.begin()->second > 1){
            max_map.begin()->second--;
            min_map[max_map.begin()->first]--;
            return;
        }
        min_map.erase(max_map.begin()->first);
        max_map.erase(max_map.begin());
    }
    else{//del min
        if(min_map.begin()->second > 1){
            min_map.begin()->second--;
            max_map[min_map.begin()->first]--;
            return;
        }
        max_map.erase(min_map.begin()->first);
        min_map.erase(min_map.begin());
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int test;
    cin>>test;
    
    for(int i = 0; i< test; i++){
        int order;
        cin>>order;
        
        map<int,int> new_min;
        map<int,int, greater<int>> new_max;
        
        min_map.swap(new_min);
        max_map.swap(new_max);
    
        for(int j = 0; j<order; j++){
            string type;
            int num;
            cin>>type>>num;
            
            cal(type, num);
        }
        
        if(max_map.empty()) cout<<"EMPTY"<<endl;
        else cout<<max_map.begin()->first<<" "<<min_map.begin()->first<<endl;
    }
    
    return 0;
}