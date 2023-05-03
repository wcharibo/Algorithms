#include <iostream>
#include <string>
#include <vector>

using namespace std;
int main(){
    int cityNum, oil, min, a, end, oilCost=0;
    vector <int> cityLength;
    vector <int> cityCost;

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
    
    
    for (int j = 0; j < cityNum-1; j++)
    {
        min=1;
        oil=cityLength[j];
        end=j;
        for (int i = j+1; i < cityNum-1; i++)
        {
            if(cityCost[j]<=cityCost[i]&&min==1){
                oil+=cityLength[i];
                min=1;
                end=i;
            }
            else {
                min=0;
                }
        }
        oilCost+=(oil*cityCost[j]);
        j=end;
    }
    
    cout<<oilCost;
}