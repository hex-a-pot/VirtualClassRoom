#include<iostream>

using namespace std;

void sort(int *arr, int size)
{
	for(int i = 0; i<size; i++)
	{
		int j = i-1;
		int key = arr[i];
		while(j>=0 && key<arr[j])
		{
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}
}
int main()
{
	int size;
	cin>>size;
	int *arr = new int[size];
	for(int i = 0; i<size; i++)
	cin>>arr[i];
	sort(arr,size);
	cout<<arr[size-2];
	return 0;
}
