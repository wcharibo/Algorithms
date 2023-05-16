#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
    int num;
    cin>> num;
    for (int i = 0; i < num*2-1; i++)
    {
        for (int j = 0; j < abs(num-(i+1)); j++)
        {
            cout<<' ';
        }
        for (int j = 0; j < 2*num-1-2*(abs(num-(i+1))); j++)
        {
            cout<<'*';
        }
        cout<<endl;   
    }   
}