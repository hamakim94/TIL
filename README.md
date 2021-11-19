# DFS 했던 실수

1. 날짜 관련
   - 시작 일수를 1로 잡는건 생각보다 중요 -> 빈 list에 0을 넣어서
2. 조합 관련
   - 조합에서는 check list를 만들어, 넣고, 다음에 빼면 좋음
3. 항상 sum이나 다른 변수를 두자, 그래서 각 단계로 더하자



# 21.11.09 DFS

1. 순열, 조합, L은 그냥 개수라고 생각하고, [0]으로된 리스트를 만들어서, a[L] = 값 대입!



- 중복 가능 순열 : 조합 : for문 m번 돌리면된다

- 순열(중복 X) : ch 리스트를 만들어서, 체크돼있으면 넘어가기, 끝나면 다시 0으로

- 조합 : ch리스트와(중복방지), s라는 새로운 변수를 만들어서, for문의 시작 지점을 s로

  그리고 새로운 DFS에 안에 들어가는게 뭔지 확인하자.



### 동전 바꿔주기 문제

- 웬만하면 Tree를 그려서, for문을 어떻게 쉽게 적용할지 생각.
- 답이 안 나오는거 같으면, 자꾸 관점을 바꿔서 어떻게 쉽게 하지를 생각하자..



### 숫자를 문자로 바꿔주기

1부터 소문자 a다

64를 더하면 대문자가 된다

따라서 chr(숫자 + 64) 하면 대문자가 돼



# 21.11.10 BFS

### BFS : 주로 While문을 활용한다 + Queue!

- from collections import deque
- for문을 돌면서, que에 append 하고, 만약 있으면 안 하고, 없으면 체크하고 하고.
- 그다음 popleft()하고 하나씩 pop해서 계속 진행!
- while문을 쓰고,  어떻게 끝날지 생각하는게 중요하다!

**리스트 => 늘 범위 확인.. exit_code_1**(11/11 복습)



### 격자판 탐색

dx = [-1, 0, 1, 0]

dy = [0, 1, 0, -1] => for문 돌기,  중앙부터 돌아~

dis를 활용해 제한 구하기( 11/11)

혹은 deque 자체에  길이를 구해서(pop 하기 전) for문을 돌리면 더 쉽다(11/11)



### 최단거리 행렬

- 행렬이 주어지면,  그 행렬에 맞는 dis 행렬 만들어야해
- 조건에 맞는거면, 그 전 위치 + 1로 새 위치를 지정하면서 진행하자.
- DIS 행렬이면 됐던거다



# 11/11 내용추가

* 아파트 단지 문제 : 문제에서 0, 1로 주어진다(갔던곳 0으로 해~)

* for문 여러번 도는거, 그닥 오래걸리는거 아니니까, 차근차근 해결해보자

*  for문의 특정 조건을 만났을 때, DFS를 돈다라는 것도 가능

  - 이럴 때 내가 원하는 변수를 어디서 선언하고, 어떻게 반영할지 만드는게 중요하다

  (다시 해보기...!!)



# 21/11/12 (격자탐색 - BFS, DFS)

### 안전구역문제

- 최대한 원본 데이터는 건들지 마(0,1이 아니고, 조건이 여러개 주어졌으면)
- 그런데 for문 돌고싶어 -> 매번 새로운 체크리스트 만들어서, 체크해 조건에 넣어
- 최대값, max(기존, 새로운 값) 이렇게 해도 가능
- 조건이 너무 많으면, cnt=0 인 지점을 찾아서 break하면 된다



# 21/11/15  DFS, BFS

- BFS : 보통 최소! 최소를 구할 때, 그런데 어떻게?
  - dis행렬을 이용해 몇 번 했는지 count해그냥!!!!!!!



### 사다리타기 문제

- 끝에서부터 생각하면 되는게 맞아, 가끔은 거꾸로 문제를 풀 생각을!
- 행렬 좀 어려우니까, x, y을 행번호, 열번호 라고 생각해버리자 그냥
- 만약 여러개로 분기가 나뉘고, 같은 곳을 가면 안 되는 경우
  - if, elif, else로 나눠서, 각각 DFS 따로 넣으면 사다리 역순으로 갈 수 있음.
- 그치, for문은 반복이고, 조건문은 그냥 각 조건에 따라 들어간다는거야!



# 21/11/16 DFS(combi), Divide and Conquer AL

### DFS(using combination)

- when making CB(combination) by using DFS
  - cb = [0]*len(size), cb[L] = any type of data(tuple, list, etc..)
  - **it's important to make empty list! ** => much easier
  - if we append to an empty list => **have to pop after DFS** 
- using LOOP with  k = [ (tuple), (tuple)] (반복문)

~~~ python
for i in range(len(LOOP)): 
    x = LOOP[i][0]
    y = LOOP[i][1]
~~~

much easier to approach data

### Divide and conquer Algorithm

- using recursive function
- sorting array(list)
- using indexes(lt, rt)
- go through all recursive(divide arr into 2 pieces)
- then do comparison(using while, lt+1, rt+1 ... )
- it's important to think all circumstances
- let's do it again tomorrow

# 21/11/17 Quick Sort / Dynamic Programming

### Quick Sort

- pivot( comparison standard) : my case : (rt)

- ~~~python
  # pivot and pos is important #
  def Qsort(lt, rt)
      if lt < rt: # most important
          pivot = a[rt]
          pos = lt
          for i in range(lt, rt): # does not include *rt*
              if a[i] < pivot:
                  a[i], a[pos] = a[pos], a[i] # python list exchange
                  pos += 1
              a[rt], a[pos] = a[pos], a[rt]
          Qsort(lt, pos - 1)
          Qsort(pos + 1, rt) # pos : already find the right space
  ~~~

- Divide and Conquer : Post-Order(후위순회), Quick sort : Pre-Order(전위순회)?????????

### Dynamic Programming(bottom-up) => bottom up

- Problem I have : If I use DFS(recurisive fucntion), TIME LIMIT EXCEEDED....
- Breakdown problem into small pieces!! ( then resolve bigger pieces )

##### BOTTOM -> UP

- recurrence relation(점화식)!!!!
- READ QUESTION CAREFULLY, AND SEE THE in SMALLEST,  and SMALLEST + 1  and ...

~~~ python
re = [0] * ( n+1 )
re[1] = 1 # by reading question
re[2] = 2
for i in range(3, n+1):
    re[i] = re[i-1] + re[i-2] # recurrence relation
~~~

##### TOP-DOWN ( Memoization Algorithm) 

- while recursion, make list(python) and memorize the output of the smaller part and use it

  later when going up tree

- **MEMOIZATION** makes top down faster

  - without it, it's same as recursion( we have to memo and use it == prunning)

  ~~~ python
  def DFS(len):
      if re[len] > 0: # prunning => makes it faster
          return re[len]
      if len == 1 or len == 2:
          return len
      else:
          re[len] = DFS(len -1) + DFS(len - 2)
          return re[len]
  
  if __name__ == "__main__":
      n = int(input())
      re = [0] * (n +1)
      print(DFS(n))
  ~~~

  # 21/11/19  LIS(Longest Increasing Subsequence)

  
  
  

dfsdfsdf

