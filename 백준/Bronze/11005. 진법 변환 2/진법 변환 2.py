ans = ''
x, y = map(int, input().split())
while x:
    r = x % y
    if 0 <= r <= 9:
        ans += str(r)
    else:
        ans += chr(ord('A') + r - 10)
    x //= y
print(ans[::-1])