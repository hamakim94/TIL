import sys
sys.stdin = open('C:/Users/mingy/OneDrive/바탕 화면/Algorithm/input.txt', 'rt')

n = int(sys.stdin.readline())

cnt = 0
for i in range(1,n+1):
    k = str(i)
    if len(k) <= 2:
        cnt += 1
    else:
        t = set()
        for j in range(len(k)-1):
            t.add( int(k[j]) - int(k[j+1]))
        if len(t) == 1:
            cnt += 1

print(cnt)
