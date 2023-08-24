import sys
sys.stdin = open('C:/Users/User/Desktop/Algorithm/input.txt', 'rt')
n = int(input())
for _ in range(n):
    start, end = map(int, input().split())
    dist = end - start
    n = 0
    while True:
        n += 1
        if dist <= n*(n+1):
            break

    if dist > n**2:
        print(2*n)
    else:
        print(2*n -1)

    
            
    