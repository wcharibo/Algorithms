#include <string>
#include <vector>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> manual({1,2,3,1});
    vector<int> on_order;
    
    for(int i : ingredient){
        on_order.push_back(i);
        
        if(i == 1 && on_order.size() > 3){
            int flag = 1;
            
            for(int j = 0; j < 4; j++){
                if(on_order[on_order.size() - 4 + j] != manual[j]) flag = 0;
            }
            
            if(flag == 1){
                for(int j = 0; j < 4; j++) on_order.pop_back();
                answer++;
            }
        }
        
    }
    
    
    return answer;
}