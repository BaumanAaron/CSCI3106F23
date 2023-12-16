import sys
from collections import deque

size = [int(x) for x in input().split()]
grid = []

for i in range(size[0]):
    row = [int(x) for x in list(input())]
    grid.append(row)


graph = [[sys.maxsize for i in range(size[1])] for curr in range(size[0])]
graph[0][0] = 0

q = deque()
q.append((0,0,0))


while q:
    #print(graph)
    item = q.popleft()
    r, c, moves = item[0], item[1], item[2]
    curr = grid[r][c]

    # up
    if r-curr >= 0 and graph[r-curr][c] > moves + 1:
        graph[r-curr][c] = moves + 1
        q.append((r-curr,c,moves+1))

    # down
    if r+curr < size[0] and graph[r+curr][c] > moves + 1:
        graph[r+curr][c] = moves + 1
        q.append((r+curr,c,moves+1))

    # left
    if c-curr >= 0 and graph[r][c-curr] > moves + 1:
        graph[r][c-curr] = moves + 1
        q.append((r,c-curr,moves+1))

    # right
    if c+curr < size[1] and graph[r][c+curr] > moves + 1:
        graph[r][c+curr] = moves + 1
        q.append((r,c+curr,moves+1))
    

val = graph[size[0]-1][size[1]-1]
print(val) if val < sys.maxsize else print(-1)