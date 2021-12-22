import sys
sys.stdin = open('C:/Users/User/Desktop/Algorithm/input.txt', 'rt')

k = int(input())
for _ in range(k):
    h, w, n = map(int, input().split())
    room_num = n // h
    height = n % h
    
    if n%h == 0:
        print(h, "{0:02d}".format(room_num), sep = '')
    else:
        print(height, "{0:02d}".format(room_num + 1), sep = '')
    