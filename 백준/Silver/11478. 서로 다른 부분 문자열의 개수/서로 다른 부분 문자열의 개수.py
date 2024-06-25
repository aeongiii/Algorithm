S = input()
A = dict()
for i in range(len(S)):
    start = 0
    end = i
    while end<len(S):
        if S[start:end+1] in A:
            start += 1
            end += 1
            continue
        else:
            x = S[start:end+1]
            A[x] = 1
            start+= 1
            end += 1
        
print(len(A))