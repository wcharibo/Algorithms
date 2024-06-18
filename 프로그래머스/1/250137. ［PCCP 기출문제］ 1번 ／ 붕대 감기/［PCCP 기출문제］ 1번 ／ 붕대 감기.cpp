#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    int attack_cnt = 0;
    int heal_cnt = 0;
    int current_health;
    
    for(int i=0; i<=attacks[attacks.size()-1][0]; i++){
        if(i==0) current_health = health;
        else if(i==attacks[attack_cnt][0]){
            current_health -=attacks[attack_cnt][1];
            if(current_health<=0){
                answer=-1;
                return answer;
            }
            attack_cnt++;
            heal_cnt=0;
        }
        else{
            heal_cnt++;
            current_health+=bandage[1];
            if(heal_cnt==bandage[0]){
                current_health+=bandage[2];
                heal_cnt=0;
            }
            if(current_health>health) current_health=health;
        }
               
    }
    answer = current_health;
    return answer;
}