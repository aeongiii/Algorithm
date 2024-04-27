# 사용자 입력을 받기 위한 함수를 정의합니다.
n = int(input())
squares = []
for _ in range(n):
    x, y = map(int, input().split())
    squares.append((x, y))

# 총 면적을 계산합니다.
square_size = 10
total_area = 0
covered_points = set()

# 겹친 면적을 계산합니다.
for square in squares:
    for i in range(square[0], square[0] + square_size): # 가로 x부터 x+10까지
        for j in range(square[1], square[1] + square_size): # 세로 y부터 y+10까지
            if (i, j) not in covered_points:
                    total_area += 1            # 좌표가 추가될때마다 +1
                    covered_points.add((i, j)) # 모든 좌표를 기록해둔다.
print(total_area)
