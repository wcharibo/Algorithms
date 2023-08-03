#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int num;
    
    cin>>num;

    vector<pair<int, int> > arr;
    vector<int> arr_1(num);
    
    for(int i=0; i<num; i++){
        int temp;
        cin>>temp;
        arr.push_back(make_pair(temp, i));
    }
    
    sort(arr.begin(), arr.end());
    
    int cnt=0;
    for(int i=0; i<num; i++){
        arr_1[arr[i].second]=cnt;
        if(i!=num-1 && arr[i].first != arr[i+1].first) cnt++;
    }
    
    for(int i=0; i<num; i++){
        cout<<arr_1[i]<<' ';
    }
}
