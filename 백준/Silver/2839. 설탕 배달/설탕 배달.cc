#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    int sugar;
    cin>>sugar;
    int min = sugar;
    for (int i = 1; i <= sugar/3; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            if(5*j+(i-j)*3==sugar){
                if(min>i) min = i;
            }
        }
    }
    if (min==sugar)
    {
        cout<<-1;
    }
    else cout<<min;
    
}