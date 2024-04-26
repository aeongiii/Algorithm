# 등급에 따른 과목 평점 매핑
avg_dict = {
    'A+': 4.5, 'A0': 4.0,
    'B+': 3.5, 'B0': 3.0,
    'C+': 2.5, 'C0': 2.0,
    'D+': 1.5, 'D0': 1.0,
    'F': 0.0, 'P': None
}

total_subject = 0  # 전공과목별 (학점 x 과목평점)의 합
total_score = 0        # 학점의 총합

# 20줄에 걸쳐 입력을 받음
for _ in range(20):
    data = input().split()
    subject = data[0]
    score = float(data[1])
    grade = data[2]

    if grade != 'P':  # 'P' 등급 과목은 계산에서 제외
        subject_score = score * avg_dict[grade]
        total_subject += subject_score
        total_score += score

# 전공 평점 계산
major = total_subject / total_score
print(f"{major:.6f}")