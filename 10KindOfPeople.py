
from itertools import chain


def flood_fill(x ,y, old, new):
    # we need the x and y of the start position, the old value,
    # and the new value
    # the flood fill has 4 parts
    # firstly, make sure the x and y are inbounds
    if x < 0 or x >= len(people[0]) or y < 0 or y >= len(people):
        return
    # secondly, check if the current position equals the old value
    if people[y][x] != old:
        return

    # thirdly, set the current position to the new value
    people[y][x] = new
    # fourthly, attempt to fill the neighboring positions
    flood_fill(x+1, y, old, new)
    flood_fill(x-1, y, old, new)
    flood_fill(x, y+1, old, new)
    flood_fill(x, y-1, old, new)

row, column = input().split()

ans = {}
new_num = int(2)
people = [[-1]*int(column)]*int(row)
for i in range(int(row)):
    people[i] = list(map(str,input()))



for x in range(int(row)):
    for y in range(int(column)):
        if people[x][y] != '1' and people[x][y] != '0':
            continue
        #print('num',new_num)
        print('current: ', people[x][y])
        # print(ans)
        if people[x][y] == '1':
            flood_fill(x,y,'1',new_num)
            ans[new_num] = 'decimal'
            new_num += 1
            print('Deciaml: ',people)
        if people[x][y] == '0':
            flood_fill(x,y,'0',new_num)
            ans[new_num] = 'binary'
            new_num += 1
            print('Binary: ',people)
        if '0' not in chain(*people) and '1' not in chain(*people):
            print('done')
        


#print(people)

for z in range(int(input())):
    x_from,y_from,x_to,y_to = input().split()
   

    if people[int(x_from)-1][int(y_from)-1] == people[int(x_to)-1][int(y_to)-1]:
        print(ans[people[int(x_from)-1][int(y_from)-1]])
    else:
        print('neither')
