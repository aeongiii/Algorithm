
word = input().upper() # 대소문자 구분X
word_dict = {}

for spell in word:
    if spell in word_dict : 
        word_dict[spell] += 1
    else :
        word_dict[spell] = 1

# value값의 최댓값에 대한 모든 key를 출력해야 --> max보다는 리스트 컴프리핸션 사용
max_spell = [k for k, v in word_dict.items() if max(word_dict.values()) == v]

if len(max_spell) == 1:
    print(max_spell[0])

else:
    print('?')