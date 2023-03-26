#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <ctime>
#include <mutex>

using namespace std;
#define MAX_NUM 100000;

class IntArray
{
private:
    vector<int> arr;
    string line;
    int n = MAX_NUM;
    int g_num = 0;
    mutex g_mutex;
    int cnt;

public:
    pthread_mutex_t lock;

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
        while (i != arr.size())
        {   
            if (i==arr.size()-1)
            {
                outputFile << arr[i];
                return;
            }
            
            outputFile << arr[i] << ','<<endl;
            i++;
        }
        outputFile.close();
        cout<<"writing file is done!!";
    };

    void showArr()
    {
        int i = 0;
        cnt = 0;
        while (i != arr.size()-1)
        {
            cout << arr[i] << ' ';
            i++;
            cnt++;
        }
        cout << endl;
        if(i==arr.size()-1){cout<< "this is EOF" << endl;} 
        cout<<"cnt = "<<cnt<<endl;
        cout<<"size = "<< arr.size();
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
        for(int i = 1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0&&arr[j]>key){
                arr[i] = arr[j];
                j--;
            }
        }
    };

    void createArr(){

        for(int i = 0; i<100000;i++)
        {   
            arr.push_back(i+1);
        }

        cout << "1 to 100k arr made"<< endl;
    }

    void fisherYatesShuffle() {
        int n = arr.size();

        for (int i = n -1 ; i >= 1; i--)
        {
            int j = rand()%(i+1);
            swap(arr[i], arr[j]);
        }

        cout<< "shuffled"<<endl;
    }
};

int main()
{
    IntArray arr;

    // arr.readFile("beforeSort100k.csv");
    // clock_t start = clock();
    // arr.selectionSort();                    //Insert arr.________sort();
    // clock_t finish = clock();
    // arr.showArr();
    // arr.writeFile("afterSort.csv");
    // cout<< endl;
    // cout<< "The execution time is about "<<(finish - start)/CLOCKS_PER_SEC << "sec" << endl;
    arr.createArr();
    
    arr.fisherYatesShuffle();

    arr.showArr();

    arr.writeFile("beforeSort100k.csv");    
    


    return 0;
}