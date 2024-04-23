import sys
import re

word = sys.stdin.readline().strip() # 입력받기

word = re.sub("dz=", "A", word) 
word = re.sub("(c=|c-|d-|lj|nj|s=|z=)", "A", word)

print(len(word))