n, m= map(int, input().split())

board = []  # 체스판 상태 입력받을 리스트
result = [] # 시작점에 따른 경우의 수를 모두 모아놓음


for i in range(n):
    board.append(input())

for i in range(n-7):   # 자르기 시작할 위치(가로) : n번째부터 최소한 -8개 전부터는 시작해야 인덱스를 벗어나지 않음
    for j in range(m-7):  # 자르기 시작할 위치(세로)
        black = 0
        white = 0

        for a in range(i, i+8):  # 자르기 끝 위치(가로) : 여기까지 하나씩 돌면서 탐색할 예정
            for b in range(j, j+8):  # 자르기 끝 위치(세로) : 여기까지 하나씩 돌면서 탐색할 예정
                if (a+b)%2 == 0 :
                    if board[a][b] != 'B':
                        white += 1   # W이면 white +1
                    else :
                        black += 1   # B이면 black +1
                else :
                    if board[a][b] != 'W':
                        white += 1   # W이면 white +1
                    else : 
                        black += 1   # B이면 black +1

        result.append(black)  # 현재 시작점(a,b)에서의 black, white를
        result.append(white)  # 리스트에 저장한 후 새로운 시작점(a, b) 계산

print(min(result))