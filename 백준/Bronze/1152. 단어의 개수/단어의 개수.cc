#include <iostream>
#include <sstream>
#include <string>

using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    string sentence, temp;
    getline(cin, sentence);
    stringstream ss(sentence);
    
    int i = 0;
    while(ss >> temp) i++;
    
    cout << i;
}