#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main(){
    int cityNum, min;
    long long a, oil, oilCost;
    vector <long long> cityLength;
    vector <long long> cityCost;
    oilCost=0;

    cin>>cityNum;
    for (int i = 0; i < cityNum-1; i++)
    {
        cin>>a;
        cityLength.push_back(a);
    }
    
    for (int i = 0; i < cityNum; i++)
    {
        cin>>a;
        cityCost.push_back(a);
    }

    min=cityCost[0];
    oilCost+=min*cityLength[0];

    for (int j = 1; j < cityNum-1; j++)
        {
        if(min>=cityCost[j]){
            
            min=cityCost[j];
        }
       
        oilCost+=(min*cityLength[j]);
    }
    
    
    cout<<oilCost;
}