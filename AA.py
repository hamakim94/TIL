import sys
sys.stdin = open("C:/Users/mingy/OneDrive/바탕 화면/Algorithm/input.txt")

def DFS(L):
    global ans, cnt
    if L > n:
        return
    if L == len(a):
        print(''.join(ans))
        cnt += 1
    else:
        if int(a[L]) == 0:
            return
        else:
            ans.append( d[int(a[L])])
            DFS(L+1)
            ans.pop()
            if int(a[L:L+2] ) <= 26 and L+2 <=n+1:
                ans.append( chr(int( a[L:L+2] ) + 64))
                DFS(L+2)
                ans.pop()


if __name__ == "__main__":
    cnt = 0
    d = {}
    d[1] = "A"
    d[2] = "B"
    d[3] = "C"
    d[4] = "D"
    d[5] = "E"
    d[6] = "F"
    d[7] = "G"
    d[8] = "H"
    d[9] = "I"
    d[10] = "J"
    d[11] = "K"
    d[12] = "L"
    d[13] = "M"
    d[14] = "N"
    d[15] = "O"
    d[16] = "P"
    d[17] = "Q"
    d[18] = "R"
    d[19] = "S"
    d[20] = "T"
    d[21] = "U"
    d[22] = "V"
    d[23] = "W"
    d[24] = "X"
    d[25] = "Y"
    d[26] = "Z"
    a = input()
    n = len(a)
    ans = []
    DFS(0)
    print(cnt)