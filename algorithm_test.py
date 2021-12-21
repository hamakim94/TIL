import sys
sys.stdin = open('C:/Users/User/Desktop/Algorithm/input.txt', 'rt')

k = int(input())
res = 0
for _ in range(k):
    n = input()
    stack = []
    ans = []
    for i in n:
        if not stack:
            stack.append(i)
            ans.append(i)
        if i == stack[0]:
            continue
        else:
            stack.pop()
            stack.append(i)
            ans.append(i)

    if len(ans) == len(set(ans)):
        res += 1
print(res)
# 내 첫 생각
# 1. 중복제거(여기서부터 어려워), 리스트에 넣기
# 2. set 하기
# 3. 개수 같으면 += 1




