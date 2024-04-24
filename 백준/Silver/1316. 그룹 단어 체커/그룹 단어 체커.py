N = int(input())
count = 0  # 그룹 단어의 개수 카운트

for _ in range(N):
    word = input()
    last_seen = {}  # 각 문자가 마지막으로 나타난 위치를 저장하는 사전
    is_group_word = True

    for i, char in enumerate(word):
        if char in last_seen:
            if i - last_seen[char] > 1:  # 문자가 연속하지 않고 나타난 경우
                is_group_word = False
                break
        last_seen[char] = i  # 문자의 마지막 위치를 업데이트

    if is_group_word:
        count += 1

print(count)
