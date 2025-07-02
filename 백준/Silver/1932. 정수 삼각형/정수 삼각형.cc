#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int tri_size, numbers;
    cin>>tri_size;

    vector<int> triangle(1, 0);
    
    int max_path = 0;

    for(int i = 1; i <= tri_size; i++){
        vector<int> temp(i, 0);
        for(int &j : temp) cin>>j;
        for(int j = 0; j < temp.size(); j++) temp[j]+=triangle[j];

        triangle.push_back(0);

        triangle[0] = temp[0];
        *(triangle.end()-1) = *(temp.end()-1);
        
        for(int j = 1; j < triangle.size()-1 ; j++){
            triangle[j] = max(temp[j-1], temp[j]);
        }
        
        for(int j : temp) max_path = max(max_path, j);
    }
    
    cout<<max_path;
    

    return 0;
}