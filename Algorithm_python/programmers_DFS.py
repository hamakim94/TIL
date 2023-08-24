begin = "hit"
target = "cog"	
words = ["hot", "dot", "dog", "lot", "log", "cog"]
n = len(words)
for i in range(len(words)):
    if words[i] == target:
        words.pop(i)
if n != len(words):
    #원하는거
    print('you can change')
else:
    print(0)
      
answer = 0
words.insert(0, begin)
words.append(target)
graph = [ [0]*len(words) for _ in range(len(words))]
cnt = [ [0]*len(words) for _ in range(len(words))]
used = [0 for _ in range(len(words))]

for i in range(len(words)):
    for j in range(i+1, len(words)):
        for a in words[i]:
            for b in words[j]:
                if a == b:
                    cnt[i][j] += 1
                    cnt[j][i] += 1

for i in range(len(cnt)):
    for j in range(len(cnt)):
        if cnt[i][j]== len(begin) - 1:
            cnt[i][j] = 1
        else:
            cnt[i][j] = 0

count = 0
def DFS(L):
    global count
    used[L] = 1
    for i in range(len(words)):
        if cnt[L][j] != 0 and used[j] == 0:
            count += 1
            DFS(j)
            
        