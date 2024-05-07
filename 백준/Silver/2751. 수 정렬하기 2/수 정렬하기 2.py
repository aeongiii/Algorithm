import sys

n = int(sys.stdin.readline().strip())
num_list = []

for i in range(0, n):
    num = int(sys.stdin.readline().strip())
    num_list.append(num)

num_list.sort()

for i in range(0, n):
    print(str(num_list[i])) # print함수는 자동 줄바꿈 포함