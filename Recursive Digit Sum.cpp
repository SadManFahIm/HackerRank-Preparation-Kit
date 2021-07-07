#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int super_digit( long long k ) {
    if ( k < 10 ) {
        return k;
    }
    
    long long sum = 0;
    while( k > 0 ) {
        sum += k % 10;
        k = k / 10;
    }
    return super_digit( sum );
}


long long sum_initial( string number ){
    long long sum = 0;
    
    for( int i = 0; i < number.size(); i++ ) {
        sum += number[i] - '0';
    }
    
    return sum;
}


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    string  n;
    int k;
    cin >> n >> k;
    long long repeated = sum_initial(n) * k;
    
    long long result = super_digit(repeated);
    
    cout << result << "\n";
    
    
    
    
    return 0;
}