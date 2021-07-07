#include <map>
#include <set>
#include <list>
#include <cmath>
#include <ctime>
#include <deque>
#include <queue>
#include <stack>
#include <string>
#include <bitset>
#include <cstdio>
#include <limits>
#include <vector>
#include <climits>
#include <cstring>
#include <cstdlib>
#include <fstream>
#include <numeric>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <unordered_map>

using namespace std;


int main(){
    int p;
    cin >> p;
    for(int a0 = 0; a0 < p; a0++){
        int n;
        cin >> n;
        bool isprime = true;
        for (auto j = 2; j <= sqrt(n); ++j) {
            if ( n%j == 0) {
                isprime = false;
                break;
            }
        }
        if ( n == 0 || n == 1) isprime = false;
        if ( isprime) cout << "Prime" << endl;
        else cout << "Not prime" << endl    ;
    }
    
    
    return 0;
}