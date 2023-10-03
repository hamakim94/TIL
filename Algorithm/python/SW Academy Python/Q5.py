import sys
sys.stdin = open('C:/Users/mingy/OneDrive/바탕 화면/Algorithm/SW Academy Python/input.txt', 'rt')


a = int(input())

res = []
while a:
    res.insert(0, str(a%2))
    a = (a//2) 
    print(a)

print(''.join(res))
