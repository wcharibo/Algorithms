#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool descend(int j, int k){
    return j>k;
}

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(), descend);
    
    for(size_t i=0; i < A.size(); ++i) answer+=A[i]*B[i];
    
    return answer;
}