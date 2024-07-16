#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, vector<int> tangerine) {
    int answer = 0, temp = 0, j = 0;
    vector <int> tng_count(10000000,0);
    
    for(int i : tangerine){
        tng_count[i-1]++;
    }
    
    sort(tng_count.begin(), tng_count.end(), greater<int>());
    
    while(temp<k){
        temp+=tng_count[j];
        j++;
    }
    
    answer+=j;
    
    return answer;
}