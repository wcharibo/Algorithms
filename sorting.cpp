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

public:
    /**파일 읽기*/
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
    /**파일 쓰기*/
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
            if (i == arr.size() - 1)
            {
                outputFile << arr[i];
                return;
            }

            outputFile << arr[i] << ',' << endl;
            i++;
        }
        outputFile.close();
        cout << "writing file is done!!";
    };
    /**배열 생성*/
    void createArr()
    {
        for (int i = 0; i < 10; i++)
        {
            arr.push_back(i + 1);
        }
        cout << "1 to 100k arr made" << endl;
    }

    /** 생성된 배열을 랜덤하게 섞음 Fisher-Yates shuffle algorithm으로 맨 뒤의 숫자를 1부터 해당 인덱스 -1 까지 랜덤하게 선택해서 swap*/
    void fisherYatesShuffle()
    {
        int n = arr.size();

        for (int i = n - 1; i >= 1; i--)
        {
            int j = rand() % (i + 1);
            swap(arr[i], arr[j]);
        }
        cout << "shuffled" << endl;
    }
    /**배열 보여주기*/
    void showArr()
    {
        int i = 0;
        while (i != arr.size())
        {
            cout << arr[i] << ' ';
            i++;
        }
        cout << endl;
        cout << "this is EOF" << endl;
    };
    /**베얄의 값들 중 최대값을 가지는 인덱스 반환*/
    int getMaxIndex(int j)
    {
        int maxIndex = 0;
        for (int i = 1; i < j + 1; i++)
        {
            if (arr[i] > arr[maxIndex])
            {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    /**선택 정렬*/
    void selectionSort()
    {
        for (int i = n - 1; i > 0; i--)
        {
            swap(arr[i], arr[getMaxIndex(i)]);
        }
    };
    /**버블 정렬*/
    void bubbleSort()
    {
        for (int i = n; i > 1; i--)
        {
            for (int j = 0; j < i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    swap(arr[j], arr[j + 1]);
                }
            }
        }
    };
    /**개선된 버블 정렬 - 버블 정렬은 뒤에서부터 앞으로 배열이 정렬이 돼있는 지 확인하는 데 배열이 정렬돼있다면 flag를 1로 하여 반복문은 종료시키는 방법으로 개선*/
    void advancedBubbleSort()
    {
        int flag = 1;
        for (int i = n; i > 1; i--)
        {
            flag = 0;
            for (int j = 0; j < i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    swap(arr[j], arr[j + 1]);
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
    }
    /**삽입 정렬*/
    void insertionSort()
    {
        for (int i = 1; i < arr.size(); i++)
        {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    };
    /**병합 정렬*/
    void mergeSort(int a, int b)
    {
        if(a<b){    //이렇게 해야 recursion이 끝남
        int m = (a+b)/2;

        mergeSort(a,m);
        mergeSort(m+1, b);

        arrMerge(a,m,b);
        }
    }
    /**병합 정렬을 호출하려면 mergeSort(int, int)를 사용하세요*/
    void arrMerge(int a, int m, int b){
        vector <int> arrL, arrR;
        for(int i=a; i<=m;i++){
            arrL.push_back(arr[i]);
        }
        for(int i =m+1;i<=b;i++){
            arrR.push_back(arr[i]);
        }
        int i = 0, j =0, k = a;
        while(i<arrL.size() && j<arrR.size()){
            if(arrL[i]<arrR[j]){
                arr[k] = arrL[i];
                i++;
            } else{
                arr[k] = arrR[j];
                j++;
            }
            k++;
        }
        while(i<arrL.size()){
            arr[k] = arrL[i];
            k++;
            i++;
        }
        while(j<arrR.size()){
            arr[k] = arrR[j];
            k++;
            j++;
        }
    }
    /**퀵 정렬*/
    void quickSort(int b, int t){
        if(b<t){
            int a = partition(b,t);
            quickSort(b, a-1);
            quickSort(a+1,t);
        }
    }
    /**퀵 정렬을 호출하려면 quickSort(int, int)를 사용하세요*/
    int partition(int b , int t){
        int x = arr[t];
        int i = b-1;
        for(int j = b; j<t; j++){
            if(arr[j]<=x){
                swap(arr[++i], arr[j]);
            }
        }
        swap(arr[i+1], arr[t]);

        return i+1;
    }

    void buildMinHeap(){
        for(int i = (arr.size()-1)/2; i>=0; i--){
            minHeapify(i, arr.size()-1);
        }
    };
    void minHeapify(int i, int n) {
        int left = 2*i+1, right = 2*i+2, smallest=i;
        if(right <= n){
            if(arr[left]<arr[right]) smallest = left;
            else smallest = right;
        }
        else if(left <= n){
            smallest = left;
        }
        else return;

        if(arr[smallest]<arr[i]){
            swap(arr[smallest], arr[i]);
            minHeapify(smallest, n);
        }
    };
    void heapSort() {
        buildMinHeap();
        for(int i = arr.size()-1; i>=1;i--){
            swap(arr[0],arr[i]);
            minHeapify(0, i-1);
        }
    };
};

int main()
{
    IntArray arr;

    arr.createArr(); //make 1 to 10 array
    arr.fisherYatesShuffle();
    arr.showArr();
    // arr.readFile("beforeSort100k.csv");
    clock_t start = clock();
    /** Insert arr.________sort(); */ 
    // arr.heapSort();
    // arr.quickSort(0,99999);
    // arr.mergeSort(0,99999);
    arr.insertionSort();
    // arr.bubbleSort();
    // arr.advancedBubbleSort();
    // arr.selectionSort();
    clock_t finish = clock();
    arr.showArr();
    // arr.writeFile("afterSort.csv");
    cout << endl;
    cout << "The execution time is about " << (finish - start) / CLOCKS_PER_SEC << "sec" << endl;
    // arr.writeFile("beforeSort100k.csv");
    return 0;
}