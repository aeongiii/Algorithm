import sys
from collections import Counter
input_word = sys.stdin.readline().strip().upper()
counter = Counter(input_word)
max_freq = max(counter.values())
most_frequent = [char for char, freq in counter.items() if freq == max_freq]
if len(most_frequent) == 1:
    print(most_frequent[0])
else:
    print('?') 
