//����ֻ��һ�У�������������a, b��Ҫ�����[a, b]�����еĻ�������a, b<10 ^ 6*
#include<iostream>
using namespace std;
bool ishuiwen(int a){
	int d[10];
	int index = 0;
	while (a){
		d[index] = a % 10;
		a = a / 10;
		index++;
	}
	int i = 0;
	int j = index - 1;
	while (i <= j){
		if (d[i] != d[j]) return false;
		i++;
		j--;
	}
	return true;
}
int main(){
	int a;
	cin >> a;
	int b;
	cin >> b;
	int in = a;
	for (; in <= b; in++){
		if (ishuiwen(in)){
			cout << in << endl;
		}
	}
	int j;
	cin >> j;
}
