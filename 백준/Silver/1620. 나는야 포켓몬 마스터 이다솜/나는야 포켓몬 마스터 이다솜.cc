#include <iostream>
#include <vector>
#include <string>
#include <map>

using namespace std;

int main(){
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int pocketNum, testNum;
    string temp;
    cin>>pocketNum>>testNum;
    vector <string> pocketName;
    map<string, int> pocketMap;
    for(int i=0; i<pocketNum; i++){
        cin>>temp;
        pocketName.emplace_back(temp);
        pocketMap.insert(make_pair(temp,i));
    }
    for(int i=0; i<testNum; i++){
        cin>>temp;
        if(int(temp[0])<=57){
           cout<<pocketName[stoi(temp)-1]<<'\n';
           
       }
        else{
           cout<<pocketMap[temp]+1<<'\n';
        }
    }
}