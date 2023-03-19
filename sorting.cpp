#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class IntArray
{
private:
    vector<int> arr;
    string line;

public:
    IntArray() {}

    void readFile(string fileName)
    {
        ifstream inputFile(fileName);

        if (!inputFile)
        {
            cerr << "Error: File could not be opened." << endl;
            exit(1);
        }

        while (getline(inputFile, line))
        {
            istringstream iss(line);
            int value;
            while (iss >> value)
            {
                arr.push_back(value);
                if (iss.peek() == ',')
                {
                    iss.ignore();
                }
            }
        }
        inputFile.close();
    };
    void writeFile(string fileName)
    {
        ofstream outputFile(fileName);
        if (!outputFile)
        {
            cerr << "Error: File could not be closed." << endl;
            exit(1);
        }
        int i = 0;
        while (i != arr.back())
        {
            outputFile << arr[i] << ',';
            i++;
        }
        outputFile.close();
        cout<<"writing file is done!!";
    };

    void showArr()
    {
        int i = 0;
        while (i != arr.back())
        {
            cout << arr[i] << ' ';
            i++;
        }
        cout << endl;
        cout << "this is EOF" << endl;
    };
};

int main()
{
    IntArray arr;

    arr.readFile("beforeSort100k.csv");
    arr.showArr();
    arr.writeFile("afterSort.csv");

    return 0;
}