#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer(arr1.size());
    vector<vector<int>> arr_sum;
    
    arr_sum.resize(arr1.size()*arr1[0].size());
    
    for(int i = 0; i < arr_sum.size(); i++) arr_sum[i].resize(arr2.size()*arr2[0].size());
    
    for(int i = 0; i < arr_sum.size(); i++){
        for(int j = 0; j < arr_sum[i].size(); j++){
            arr_sum[i][j] = arr1[i/arr1[0].size()][i%arr1[0].size()]*arr2[j/arr2[0].size()][j%arr2[0].size()];
        }
    }
    
    for(int i = 0; i < arr1.size(); i++){
        for(int j = 0; j < arr2[0].size(); j++){
            int temp = 0;
            for(int k = 0; k < arr2.size(); k++){
                temp+=arr_sum[k+arr2.size()*i][k*arr2[0].size()+j];
            }
            answer[i].push_back(temp);
        }
    }
    
    return answer;
}