#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    string croWords;
    cin>>croWords;
    int cnt=0;
    vector <string> croatian;
    croatian.push_back("c=");
    croatian.push_back("c-");
    croatian.push_back("d-");
    croatian.push_back("lj");
    croatian.push_back("nj");
    croatian.push_back("s=");
    croatian.push_back("z=");
    croatian.push_back("dz=");

    cnt=croWords.size();
    string word2="";
    string word3="";
    if(croWords.size()>1){
    for (int i = 0; i < croWords.size()-1; i++)
    {
        word2+=croWords[i];
        word2+=croWords[i+1];
        if (count(croatian.begin(), croatian.end(),word2))
        {
            cnt--;
        }
        word2="";
        
    }
    for (int i = 0; i < croWords.size()-2; i++)
    {
        word3+=croWords[i];
        word3+=croWords[i+1];
        word3+=croWords[i+2];
        if (count(croatian.begin(), croatian.end(),word3))
        {
            cnt--;
        }
        word3="";
    }
    }
    else cnt=1;
    
    cout<<cnt;
}