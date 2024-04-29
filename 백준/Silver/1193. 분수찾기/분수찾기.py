x = int(input())
line = 1  # 몇 번째 줄에 있는지
sum = 0   # x와 비교할 대상(합산한 값)
a = 0  # 분자
b = 0  # 분모

while sum < x:
    sum += line
    line += 1

line -= 1  # while에서 마지막에 1 증가한 후 반환되었기 때문에 -1 해줌
position = sum - x + 1

# 홀수 줄 : 분자는 커지고 분모는 줄어듦
if line % 2 != 0:
    a = position
    b = line - position + 1

# 짝수 줄 : 분자는 줄어들고 분모는 커짐
else:
    a = line - position + 1
    b = position

print(f'{a}/{b}')
