#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int calBlock(vector<vector<char> > board);
int calSmallBlock(int x, int y, vector<vector<char> > board);

int main()
{
    int row, col;
    cin >> row >> col;
    vector<vector<char> > checker;
    checker.resize(row);
    for (int i = 0; i < row; i++)
    {
        checker[i].resize(col);
        for (int j = 0; j < col; j++)
        {
            cin >> checker[i][j];
        }
    }
    int result = calBlock(checker);
    cout << result;
    return 0;
}

int calBlock(vector<vector<char> > board)
{
    int min = 100000, cnt = 0;
    for (int i = 0; i <= board.size() - 8; i++)
    {
        for (int j = 0; j <= board[0].size() - 8; j++)
        {
            cnt= calSmallBlock(i,j,board);
            if (min > cnt) min = cnt;
        }
    }
    return min;
}

int calSmallBlock(int i, int j, vector<vector<char> > board)
{
    int cnt_white = 0, cnt_black = 0;
    for (int row = i; row < i + 8; row++)
    {
        for (int col = j; col < j + 8; col++)
        {
            if (row % 2 == 0)
            {
                if (col % 2 == 0)
                {
                    if (board[row][col] != 'W') cnt_white++;
                }
                else
                {
                    if (board[row][col] != 'B') cnt_white++;
                }
            }
            else
            {
                if (col % 2 == 0)
                {
                    if (board[row][col] != 'B') cnt_white++;
                }
                else
                {
                    if (board[row][col] != 'W') cnt_white++;
                }
            }
        }
    }
    for (int row = i; row < i + 8; row++)
    {
        for (int col = j; col < j + 8; col++)
        {
            if (row % 2 == 0)
            {
                if (col % 2 == 0)
                {
                    if (board[row][col] != 'B') cnt_black++;
                }
                else
                {
                    if (board[row][col] != 'W') cnt_black++;
                }
            }
            else
            {
                if (col % 2 == 0)
                {
                    if (board[row][col] != 'W') cnt_black++;
                }
                else
                {
                    if (board[row][col] != 'B') cnt_black++;
                }
            }
        }
    }
    int min = cnt_white;
    if (min > cnt_black)
    {
        min = cnt_black;
    }
    return min;
}
