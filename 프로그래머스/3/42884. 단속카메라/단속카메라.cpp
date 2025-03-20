#include <string>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    set<int, greater<int>> in;
    set<int> out;
    
    sort(routes.begin(), routes.end());
    
    for(vector i : routes){
        if(!in.empty()){
            if(i[0] > *out.begin()){
                in.clear();
                out.clear();
                answer++;
            }
            else if(i[0] == *out.begin()){
                in.clear();
                out.clear();
                answer++;
                continue;
            }
        }
        
        in.insert(i[0]);
        out.insert(i[1]);
        
    }
    
    if(!in.empty()) answer++;
    
    
    return answer;
}