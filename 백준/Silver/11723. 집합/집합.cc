#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector <int> arr(21,0);
    int num, key;
    string temp;
    unordered_map<int, int> orderMap;
    orderMap.insert({100, 6});
    orderMap.insert({101,2});
    orderMap.insert({104,1});
    orderMap.insert({111,4});
    orderMap.insert({108,5});
    orderMap.insert({109,3});
    
    cin>>num;
    
    for(int i=0; i<num; i++){
        cin>>temp;
        switch(orderMap[int(temp[1])]){
            case 1:
            cin>>key;
            cout<<arr[key]<<'\n';
            break;
            
            case 2:
            cin>>key;
            arr[key]=0;
            break;
            
            case 3:
            arr.clear();
            arr.resize(21,0);
            break;
            
            case 4:
            cin>>key;
            if(arr[key]==0) arr[key]=1;
            else arr[key]=0;
            break;
            
            case 5:
            arr.clear();
            arr.resize(21,1);
            break;
            
            default:
            cin>>key;
            arr[key]=1;
            break;
        }
    }
}