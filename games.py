import turtle as t
import random as r
import time


colors = ['black','red', 'blue', 'orange', 'yellow', 'green', 'purple', 'white']
def draw_square(block, grid):
    block.clear()
    xx = -150
    yy = 250
    for y in range(len(grid)):
        for x in range(len(grid[0])):
            sx = xx + 22*x
            sy = yy - 22*y
            block.goto(sx, sy)
            block.color(colors[grid[y][x]])
            if y == 15 and grid[y][x] == 7:
                block.color('red')
            block.stamp()

class Bricks():
    def __init__(self):
        self.y = 0
        self.x = 6
        self.color = r.randint(1,6)    
    
    def move_left(self, grid):
        if grid[self.y][self.x - 1] == 0 and grid[self.y+1][self.x - 1] == 0 : 
            # 그런데 대각선으로 움직이면, 사라져, 좌표값만 변한 상태여서 사라짐, 따라서 뒤 코드 넣어
            grid[self.y][self.x] = 0
            self.x -= 1
            
    def move_right(self, grid):
        if grid[self.y][self.x + 1] == 0 and grid[self.y+1][self.x + 1] == 0:
            grid[self.y][self.x] = 0
            self.x += 1

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

def DFS(y, x, grid, color):
    global ch, blank
    ch[y][x] = 1
    blank.append((y,x))
    for i in range(4):
        yy = y + dy[i]
        xx = x + dx[i]
        if 0<yy<24 and 0 < xx < 13:
            if grid[yy][xx] == color and ch[yy][xx] == 0:
                DFS(yy, xx, grid, color)

def max_height(grid):
    for y in range(1, 24):
        for x in range(1,13):
            if grid[y][x] != 0:
                return y

# 우선 쉽게 생각, for문을 돌면서 0이면 y-1 해가며 0이 아닌 지점을 찾고, 그 지점에 있는 숫자를 원래 숫자에..!                
def grid_update(grid, blank):
    for y, x in blank:
        grid[y][x] = 0
    height = max_height(grid)
    for y in range(23, height - 1, -1):
        for x in range(1, 13):
            if grid[y][x] == 0:
                tmp_y = y
                while grid[tmp_y-1][x] == 0 and tmp_y -1 > 0:
                    tmp_y -= 1
                grid[y][x] = grid[tmp_y-1][x] 
                grid[tmp_y-1][x] = 0
                
            

def game_over():
    pen.up()
    pen.goto(-120,100)
    pen.write("Game Over", font= ('Courier', 30))
    
def you_win():
    pen.up()
    pen.goto(-120,100)
    pen.write("You Win!!", font = ('Courier', 20))

    
    

if __name__ == "__main__":
    sc = t.Screen()
    sc.tracer(False)
    sc.bgcolor("black")
    sc.setup(width= 600, height= 700)
    
    
    # make list for game
    grid = [[0]*12 for _ in range(24)] # 24행 12열
    for i in range(24):
        grid[i].insert(0, 7)
        grid[i].append(7)
    grid.append([7]*14)
    
    for y in range(21, 24):
        for x in range(1, 13):
            grid[y][x] = r.randint(1,6)
    # for i in range(len(grid)):
        # print(grid[i])
    
    block = t.Turtle()
    block.penup()
    block.speed(0)
    block.shape("square")
    block.color("red")
    block.setundobuffer(None)
    # block.goto(-200,200)
    
    pen = t.Turtle()
    pen.ht()
    pen.goto(-80, 290)
    pen.color('white')
    pen.write("Block Game", font= ( 'Courier', 20))
    
    brick = Bricks()
    grid[brick.y][brick.x] = brick.color
    
    sc.onkeypress(lambda : brick.move_left(grid), 'Left')
    sc.onkeypress(lambda : brick.move_right(grid), 'Right')
    sc.listen()
    
    while True:
        sc.update()
        if grid[brick.y+1][brick.x] == 0:
            grid[brick.y][brick.x] = 0
            brick.y += 1
            grid[brick.y][brick.x] = brick.color
        else:
            ch = [ [0]*13 for _ in range(24)]
            blank = []
            DFS(brick.y, brick.x, grid, brick.color)
            # 지우기
            if len(blank) >= 4:
                grid_update(grid, blank)
            height = max_height(grid)
            if height <= 15:
                game_over()
                break
            elif height >= 22:
                draw_square(grid)
                you_win()
                break
            
            # 중력작용
            
            brick = Bricks()
            
        draw_square(block, grid)
        time.sleep(0.05)
    # 목표 1. fill the bottom 3 row with colors
    # 목표 2. make class Brick to get its location and color
    # Goal 3. in the while loop, we have to switch location number during loop
    # too slow. we need some more in turtle 
    # sc.tracer(False) , while, sc.update()
    # still slow, in turtle object, block.setundobuffer(None), during while, block.clear()
    # 목표 3. By using while loop, drop the brick until grid[y][x] != 0
    
    # 12/01 목표 : 연결된 길이가 4 이상이면 지우고, 중력작용해서 떨어뜨리기
    # 12/01 목표2: 행이 15가 되면(많이 쌓이면), Game Over 출력
    #              마찬가지로 행이 23 이상(2줄)이 되면 You Win 출력
    #              게임보드 위 Block Game 출력(-80, 290)
    sc.mainloop()
    
    
    
    