#include <iostream>
#include <vector>
using namespace std;
int main(){
    int n,p;
    cin>>n;
    // int time[n];
    vector <int> time;
    for (int i = 0; i < n; i++)
    {
        cin>>p;
        time.push_back(p);
    }
    int min=0;
    if(n<1||n>1000) return 0;
    for (int i = 0; i < n; i++)
    {
        if(time[i]<1||time[i]>1000) return 0;
    }
    int result=0;
    for (int j = 0; j < n-1; j++)
    {
        min=time[n-j-1];
        for (int i = 0; i < n-j; i++)
        {
            if (time[i]<=min)
            {
                min=time[i];
                swap(time[i],time[n-1-j]);
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        result+=(i+1)*time[i];
    }
    
    cout<<result;   
    

}