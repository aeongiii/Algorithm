a1, a0 = map(int, input().split())
c1 = int(input())
n0 = int(input())


if a1 * n0 + a0 <= c1 * n0  and a1 <= c1:
    print("1")
else:
    print("0")
