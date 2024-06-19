from itertools import count
import sys
input = sys.stdin.readline

dic = {}
count = 0
n, m = map(int, input().split())

for _ in range(n):
    data = input().rstrip()
    dic[data] = True

for _ in range(m):
    data = input().rstrip()
    if data in dic:
        count += 1

print(count)