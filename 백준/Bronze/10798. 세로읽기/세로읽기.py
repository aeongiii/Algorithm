import sys

arr = []
for i in range(5):
    temp = sys.stdin.readline().strip()
    arr.append(temp)

for i in range(15):
    for j in range(5):
        if i < len(arr[j]):
            print(arr[j][i], end = '')