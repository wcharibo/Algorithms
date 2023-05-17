#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    double a,b,v;
    int day=0, i , dist;
    cin>>a>>b>>v;
    i=(v-a)/(a-b);
    dist=(a-b)*(i-1);
    while(day==0){
        dist+=a;
        if (dist>=v)
        {   
            day=i;
            cout<<day;
            return 0;
        }
        dist-=b;
        i++;
    }
}
