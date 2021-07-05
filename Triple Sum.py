def triplets(a, b, c):
    # use set to get unique values, and sort the list
    a = sorted(list(set(a)))
    b = sorted(list(set(b)))
    c = sorted(list(set(c)))
    #initiate the number of options in a and c
    ia, ic = 0, 0
    result = 0
    for ib in range(len(b)):
        while ia < len(a):
            if a[ia] <= b[ib]:
                ia += 1
            else:
                break

        while ic < len(c):
            if c[ic] <= b[ib]:
                ic += 1
            else:
                break

        result += ia * ic

    return result