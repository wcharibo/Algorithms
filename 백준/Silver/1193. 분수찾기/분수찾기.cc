#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    double num, cal;
    int target;
    cin>>num;
    for (int i = 1; i < 499999; i++)
    {
        cal+=i;
        if (cal>=num)
        {
            target=i;
            break;
        }
    }
    if (target%2==0)
    {
        cout<<target-(cal-num)<<'/'<<1+(cal-num);
    }
    else if(target%2==1){
        cout<<1+(cal-num)<<'/'<<target-(cal-num);
    }
}
