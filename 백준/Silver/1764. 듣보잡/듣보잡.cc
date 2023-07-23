#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    int neverSeen, neverHeard, cnt;
    string temp;
    map <string, int> m;
    vector<string> result;
    cin>>neverSeen>>neverHeard;
    for(int i=0; i<neverSeen; i++){
        cin>>temp;
        m.insert({temp, 1});
    }
    
    for(int i=0; i<neverHeard; i++){
        cin>>temp;
        if(m.find(temp)!=m.end()) result.push_back(temp);
    }
    cout<<result.size()<<'\n';
    sort(result.begin(), result.end());
    for(int i=0; i<result.size(); i++) cout<<result[i]<<'\n';
}