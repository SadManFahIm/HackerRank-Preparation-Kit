import math
import os
import random
import re
import sys

# Complete the minimumAbsoluteDifference function below.
def minimumAbsoluteDifference(arr):
    arr.sort()
    #initiate value using the first two element
    min_dif = abs(arr[0] - arr[1])
    #go over the sorted list and compare the distance between neighbors
    for i in range(len(arr)-1):
        dif = abs(arr[i] - arr[i+1])
        if dif < min_dif:
            min_dif = dif
    return min_dif

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    result = minimumAbsoluteDifference(arr)

    fptr.write(str(result) + '\n')

    fptr.close()