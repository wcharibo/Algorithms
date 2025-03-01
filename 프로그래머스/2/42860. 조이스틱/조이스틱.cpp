#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string name) {
    int answer = 0, moved = 100;
    vector<int> changed;
  
    for(int i = 0; i < name.size(); i++){
        answer+=min(name[i] - 'A', 'Z' - name[i]+1);
        
        int x = i, y = x+1;
        
        while(y<name.size() && name[y] == 'A') y++;
        
        moved = min(moved, min((2*x+(int)name.size()-y), (2*((int)name.size()-y)+x)));
    }
    
    return answer+moved;
}