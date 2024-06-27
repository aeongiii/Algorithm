n,m = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]
b = [list(map(int,input().split())) for _ in range(n)]

for x in range(n):
    for y in range(m):
        print(a[x][y]+b[x][y],end=' ')
    print()