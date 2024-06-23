import sys
input = sys.stdin.readline

N, M = map(int, input().split())
noHear = set()
noSee = set()
for _ in range(N):
    noHear.add(input().rstrip())
for _ in range(M):
    noSee.add(input().rstrip())

noHearSee = sorted(list(noHear & noSee))

print(len(noHearSee))
for name in noHearSee:
    print(name)