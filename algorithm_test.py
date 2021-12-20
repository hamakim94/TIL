import sys
sys.stdin = open('C:/Users/User/Desktop/Algorithm/input.txt', 'rt')

n = input().upper()
ans = {}

for i in n:
    ans[i] = 0
for i in n:
    ans[i] += 1

res = [] 
maxi = 0
for i in ans.values():
    if i > maxi:
        maxi = i
        
for a,b in ans.items():
    if b == maxi:
        res.append(a)

if len(res) >= 2:
    print('?')
else:
    print(res[0])