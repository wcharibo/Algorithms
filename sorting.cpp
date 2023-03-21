#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <ctime>

using namespace std;

class IntArray
{
private:
    vector<int> arr;
    string line;
    int n = 100000;

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

    int getMaxIndex(int j){
        int maxIndex = 0;
        for(int i =1; i<j+1; i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    void selectionSort(){
        for(int i = n-1; i>0; i--){
            swap(arr[i],arr[getMaxIndex(i)]);
        }
    };

    void bubbleSort(){
        for(int i = n; i>1; i--){
            for(int j = 0; j< i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr[j], arr[j+1]);
                }
            }
        }
    };

    void advancedBubbleSort(){
        int flag = 1;
        for(int i = n; i>1; i--){
            flag = 0;
            for(int j = 0; j< i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr[j], arr[j+1]);
                    flag=1;
                }
            }
        if (flag == 0) break;
        }
    }

    void insertionSort() {

    };
};

int main()
{
    IntArray arr;

    arr.readFile("beforeSort100k.csv");
    clock_t start = clock();
    arr.advancedBubbleSort();
    clock_t finish = clock();
    arr.showArr();
    arr.writeFile("afterSort.csv");
    cout<< endl;
    cout<< (finish - start)/CLOCKS_PER_SEC << "sec" << endl;

    return 0;
}