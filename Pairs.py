def pairs(k, arr):
    result = 0
    arr = sorted(arr)
    j = 1
    for i in range(len(arr)-1):
        while j<len(arr):
            if arr[j] - arr[i] == k:
                result += 1
                j += 1
            elif arr[j] - arr[i] > k:
                break
            elif arr[j] - arr[i] < k:
                j += 1
    return result