import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    balance = 0
    ls_important = []
    for i in range(n):
        li,ti = contests[i]
        if ti == 0:
            balance += li
        else:
            ls_important.append(li)
    ls_important.sort()
    if len(ls_important)>k:
        for i in range(len(ls_important)-k):
            balance -= ls_important[i]
        for i in range(len(ls_important)-k, len(ls_important)):
            balance += ls_important[i]
    elif len(ls_important)<=k:
        for i in range(len(ls_important)):
            balance += ls_important[i]
    return balance
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()