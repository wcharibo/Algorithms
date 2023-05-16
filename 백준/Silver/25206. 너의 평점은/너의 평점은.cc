#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
#include <iterator>

using namespace std;

int main(){
    vector <string> score;

    score.push_back("A+");
    score.push_back("4.5");
    score.push_back("A0");
    score.push_back("4.0");
    score.push_back("B+");
    score.push_back("3.5");
    score.push_back("B0");
    score.push_back("3.0");
    score.push_back("C+");
    score.push_back("2.5");
    score.push_back("C0");
    score.push_back("2.0");
    score.push_back("D+");
    score.push_back("1.5");
    score.push_back("D0");
    score.push_back("1.0");
    score.push_back("F");
    score.push_back("0.0");
    score.push_back("P");

    float score_sum=0, time_sum=0;
    
    for (int i = 0; i < 20; i++)
    {
        vector <string> lecture;
        lecture.resize(3);
        for (int j = 0; j < 3; j++)
        {
            cin>>lecture[j];
            if(j!=3) cin.ignore();
        }
        if (lecture[2]!="P")
        {
            int index=distance(score.begin(), find(score.begin(),score.end(),lecture[2]));
            score_sum=score_sum+(stof(lecture[1])*stof(score[index+1]));
            time_sum+=stof(lecture[1]);
        }
    }
    
    cout<<score_sum/time_sum;
}