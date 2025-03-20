#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0, anchor = 0;
    
    sort(A.rbegin(), A.rend());
    sort(B.rbegin(), B.rend());
    
    for(size_t i = 0; i < B.size(); i++){
        for(size_t j = anchor; j < A.size(); j++){
            anchor++;
            if(A[j] < B[i]){
                answer++;
                break;
            }
        }
        
        if(anchor >= B.size()) break;
    }
    
    return answer;
}