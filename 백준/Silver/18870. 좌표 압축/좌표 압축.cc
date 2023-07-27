#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <set>

using namespace std;

vector <int> arr(11,0);

int cal(int a);

int main() {
    ios_base::sync_with_stdio(0);
    cout.tie(0);
    cin.tie(0);
    
    int num;
    
    cin>>num;
    
    set <int> arr;
    vector<int> arrOr;
    unordered_map <int, int> m;
    
    for(int i=0; i<num; i++){
        int temp;
        cin>>temp;
        arrOr.push_back(temp);
        arr.insert(temp);
    }
    int cnt=0;
    for(set<int>::iterator i=arr.begin(); i!=arr.end(); i++){
        m.insert({*i,cnt++});
    }
    
    for(int i=0; i<num; i++){
        cout<<m[arrOr[i]]<<' ';
    }
}
