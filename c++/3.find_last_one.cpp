/*************************************************************************
	> File Name: 2.find_first_one.cpp
	> Author: huguang
	> Mail: hug@haizeix.com
	> Created Time: 
 ************************************************************************/

#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <queue>
#include <stack>
#include <algorithm>
#include <string>
#include <map>
#include <set>
#include <vector>
using namespace std;
/* 11111110000000  find last one */

int binary_search_find_last_one(int *arr, int n) {
    int head = 0, tail = n - 1, mid;
    while (head < tail) {
        mid = (head + tail) / 2;
        if (arr[mid] == 1) head = mid + 1;
        else tail = mid;
    }
    if (arr[head] == 1) return head;
    head -= 1;
    if (head < 0) return -1;
    return head;
}

int main() {
    int n;
    int arr[1000];
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i];
    cout << binary_search_find_last_one(arr, n) << endl;
    return 0;
}
