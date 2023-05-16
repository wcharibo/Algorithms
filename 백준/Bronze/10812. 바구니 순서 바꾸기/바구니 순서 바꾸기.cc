#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main()
{
    int bucketNum, rotNum;
    cin >> bucketNum;
    cin >> rotNum;
    vector<vector<int> > rotation;
    rotation.resize(rotNum);
    for (int i = 0; i < rotNum; i++)
    {
        rotation[i].resize(3);
    }

    for (int i = 0; i < rotNum; i++)
    {
        for (int j = 0; j < 3; j++)
        {
            cin >> rotation[i][j];
        }
    }

    vector<int> buckets;
    buckets.resize(bucketNum);
    for (int i = 0; i < bucketNum; i++)
    {
        buckets[i] = i + 1;
    }

    for (int i = 0; i < rotNum; i++)
    {
        vector<int> start, latter;
        for (int j = 0; j < rotation[i][2] - rotation[i][0]; j++)
        {
            start.push_back(buckets[rotation[i][0] + j-1]);
        }
        for (int j = 0; j <= rotation[i][1] - rotation[i][2]; j++)
        {
            latter.push_back(buckets[rotation[i][2] + j - 1]);
        }
        for (int j = 0; j < latter.size(); j++)
        {
            buckets[rotation[i][0] - 1 + j] = latter[j];
        }
        for (int j = 0; j < start.size(); j++)
        {
            buckets[rotation[i][0] + (rotation[i][1] - rotation[i][2]) + j ] = start[j];
        }

    }
        for (int k = 0; k < bucketNum; k++)
        {
            cout << buckets[k] << ' ';
        }
}