#include <iostream>
#include <vector>
#include <string>
#include <iomanip>

using namespace std;

int main(){
    int test_num, case_num, sum=0, cnt=0;
    cin>>test_num;

    vector <float> avg, result;
    vector <int> case_score;
    for (int j = 0; j < test_num; j++)
    {
        cin>>case_num;
        cin.ignore();
        case_score.resize(case_num);
        for (int i = 0; i < case_num; i++)
        {
            cin>>case_score[i];
            sum+=case_score[i];
        }
        
        float avg=sum/case_num;
        
        for (int i = 0; i < case_num; i++)
        {
            if (avg<case_score[i])
            {
                cnt++;
            }
        }
        result.push_back(100.0*cnt/case_num);
        sum=0, cnt=0;
    }
    
    for (int i = 0; i < result.size(); i++)
    {
        cout<<fixed<<setprecision(3)<<result[i]<<'%'<<endl;
    }
    
}