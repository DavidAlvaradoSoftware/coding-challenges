// Note: since a challenge was not explicitly given for C++,
//       I will be solving the same challenge given to Java.

#include <iostream>

using namespace std;

int warOfNums(int numbersList[], int size);

int main()
{
    int promptOne[3] = { 12, 90, 75 };
    int promptTwo[12] = { 5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243 };
    
    cout << warOfNums(promptOne, end(promptOne) - begin(promptOne)) << endl;
    cout << warOfNums(promptTwo, end(promptTwo) - begin(promptTwo)) << endl;
    
    system("pause");

}

int warOfNums(int numbersList[], int size) {
    int evenTotal = 0;
    int oddTotal = 0;

    for (int i = 0; i < size; i++)
    {
        if (numbersList[i] % 2 == 0) {
            evenTotal += numbersList[i];
        } else{ 
            oddTotal += numbersList[i];
        }
    }
    return abs(evenTotal - oddTotal);
}
