#include <iostream>
#include <vector>
using namespace std;

int solution(vector<vector<int> > land)
{
    int answer = 0;
    for(int i = 1; i < land.size(); i++){
        vector<int> temp = land[i];
        for(int j = 0; j < temp.size(); j++){
            for(int k = 0; k < temp.size(); k++){
                if(k==j) continue;
                land[i][j] = max(land[i][j], temp[j]+land[i-1][k]);
            }
        }
    }
    
    int max = 0;
    for(int i : land[land.size()-1]) if(i>max) max=i;
    answer=max;

    return answer;
}