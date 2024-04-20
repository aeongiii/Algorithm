word = input()
is_palindrome = True  # 변수명을 일관되게 사용합니다.
half = len(word) // 2  # 홀수든 짝수든 이 방식이 더 나은 방법입니다.

for i in range(half):  # 글자를 반으로 나누어 앞부분에 대해
    if word[i] != word[-i-1]:  # i번째 문자와 뒤에서 i+1번째 문자를 비교 (인덱스는 0부터 시작하므로)
        is_palindrome = False  # 한 번이라도 일치하지 않으면 False
        break  # 더 이상 확인할 필요가 없으므로 반복문 탈출

if is_palindrome:
    print(1)  # 모든 검사를 통과하면 1 출력
else:
    print(0)  # 일치하지 않는 경우가 있으면 0 출력
