n = int(input())
b = n//5

while b >= 0 :
    remaining_weight = n - (b*5)
    
    if remaining_weight % 3 == 0:
        a = remaining_weight // 3
        print(a+b)
        break

    b -= 1

else:
    print(-1)
