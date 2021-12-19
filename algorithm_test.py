

a = set(range(1, 101))
gen_num = set()
# 필요한 기능, 자릿수 더해서 삭제..

for i in range(1,101):
    t = 0
    for j in str(i):
        i += int(j)
    gen_num.add(i)
    
ans = sorted(a - gen_num)
for i in ans:
    print(i)

        
