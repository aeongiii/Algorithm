n= int(input())
number = 666
t = 0

while(True):
    if('666' in str(number)):
        t += 1

    if t == n:
        break

    number += 1

print(number)