#include <iostream>
#include <vector>
#include <queue>
#include <cstdlib>

using namespace std;

class comp{
public:
    bool operator()(const int &lhs, const int &rhs)const{
        if(abs(lhs)==abs(rhs)) return lhs>rhs;
        else return abs(lhs)>abs(rhs);
    }
    
};

int main() {
    int input_num;
    cin>>input_num;
    
    priority_queue <int, vector<int>, comp> heap_arr;
    vector <int> arr(input_num);
    for(int i = 0; i<input_num; i++){
        cin>>arr[i];
    }
    for(int i=0; i<arr.size(); i++){
        if(arr[i]==0 && heap_arr.size()==0) cout<<0<<'\n';
        else if(arr[i]==0){
            cout<<heap_arr.top()<<'\n';
            heap_arr.pop();
        }
        else{
            heap_arr.push(arr[i]);
        }
    }
    
}