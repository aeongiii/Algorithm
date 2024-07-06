n,b = input().split()
digit = len(n); b = int(b); res = 0
for i in range(digit):
    check = n[i]
    if 'A' <= check <= 'Z':
        res += int((ord(check) - 55)) * (b**(digit-i-1))
    else:
        res += int(check) * (b**(digit-i-1))
print(res)