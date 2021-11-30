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
            print(len(blank))
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
    
    sc.mainloop()
    
    
    