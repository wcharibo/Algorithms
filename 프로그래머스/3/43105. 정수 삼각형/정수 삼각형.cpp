#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    int answer = 0;
    
    vector<vector <int>> sum_tri(triangle.size());
    
    for(int i = 0; i < triangle.size(); i++){
        sum_tri[i].resize(triangle[i].size());
    }
    
    sum_tri[0][0] = triangle[0][0];
    
    for(int i = 0; i < triangle.size(); i++){
        if(i+1 < triangle.size()){
            for(int j = 0; j < triangle[i].size(); j++){
                sum_tri[i+1][j] = max(sum_tri[i+1][j], sum_tri[i][j]+triangle[i+1][j]);
                sum_tri[i+1][j+1] = max(sum_tri[i+1][j+1], sum_tri[i][j]+triangle[i+1][j+1]);
            }
        }
    }
    
    vector<int> last = sum_tri[sum_tri.size()-1];
    for(int i : last) if(answer < i) answer = i;
    
    return answer;
}