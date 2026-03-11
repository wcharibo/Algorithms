#include <iostream>
#include <vector>

using namespace std;

int main(){
    int cor, rig=0;
    vector <int> answer;
    answer.resize(5);
    
    cin>>cor;
    for(int i=0; i<5; i++){
        cin>>answer[i];
    }
    for(int i=0; i<5; i++){
        if(answer[i]==cor) rig++;
    }
    cout<<rig;
}