#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    vector<vector<int> > white, black;
    white.resize(100);
    for (int i = 0; i < 100; i++)
    {
        white[i].resize(100);
    }
    int black_num, area=0;
    cin>>black_num;
    black.resize(black_num);
    for (int i = 0; i < black_num; i++)
    {
        black[i].resize(2);
    }
    for (int i = 0; i < black_num; i++)
    {
        cin>>black[i][0]>>black[i][1];
        for (int row = black[i][0]; row < black[i][0]+10; row++)
        {
            for (int col = black[i][1]; col < black[i][1]+10; col++)
            {
                if (white[row][col]==0)
                {   
                    white[row][col]=1;
                    area++;
                }
            }
        }
    }
    cout<<area;
}
