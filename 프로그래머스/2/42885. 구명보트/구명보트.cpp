#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    sort(people.begin(), people.end());
    
    int i = 0, j = people.size()-1;
    while(j>=i){
        if(people[i]+people[j]>limit){
            answer++;
            j--;
        }
        else{
            answer++;
            i++;
            j--;
        }
    }
    
    return answer;
}