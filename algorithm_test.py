import sys
sys.stdin = open('C:/Users/mingy/OneDrive/바탕 화면/Algorithm/input.txt', 'rt')
n = int(sys.stdin.readline())

for i in range(n):
    a =  list(map(int, sys.stdin.readline().rsplit()))
    m = a.pop(0)
    mean = sum(a) / m
    num = 0 
    for i in a:
        if i > mean:
            num += 1
    print("{0:0.3f}%".format(round(num / m * 100, 3)))



