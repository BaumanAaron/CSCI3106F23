
from itertools import chain
def isValid(screen, m, n, x, y, prevC, newC):
    if x<0 or x>= m\
       or y<0 or y>= n or\
       screen[x][y]!= prevC\
       or screen[x][y]== newC:
        return False
    return True
 
 
# FloodFill function
def flood_Fill(screen,  
            m, n, x,  
            y, prevC, newC):
    queue = []
     
    # Append the position of starting 
    # pixel of the component
    queue.append([x, y])
 
    # Color the pixel with the new color
    screen[x][y] = newC
 
    # While the queue is not empty i.e. the 
    # whole component having prevC color 
    # is not colored with newC color
    while queue:
         
        # Dequeue the front node
        currPixel = queue.pop()
         
        posX = currPixel[0]
        posY = currPixel[1]
         
        # Check if the adjacent
        # pixels are valid
        if isValid(screen, m, n,  
                posX + 1, posY,  
                        prevC, newC):
             
            # Color with newC
            # if valid and enqueue
            screen[posX + 1][posY] = newC
            queue.append([posX + 1, posY])
         
        if isValid(screen, m, n,  
                    posX-1, posY,  
                        prevC, newC):
            screen[posX-1][posY]= newC
            queue.append([posX-1, posY])
         
        if isValid(screen, m, n,  
                posX, posY + 1,  
                        prevC, newC):
            screen[posX][posY + 1]= newC
            queue.append([posX, posY + 1])
         
        if isValid(screen, m, n,  
                    posX, posY-1,  
                        prevC, newC):
            screen[posX][posY-1]= newC
            queue.append([posX, posY-1])



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
        #print('current: ', people[x][y])
        # print(ans)
        if people[x][y] == '1':
            flood_Fill(people,int(row),int(column),x,y,'1',new_num)
            ans[new_num] = 'decimal'
            new_num += 1
            #print('Deciaml: ',people)
        if people[x][y] == '0':
            flood_Fill(people,int(row),int(column),x,y,'0',new_num)
            ans[new_num] = 'binary'
            new_num += 1
            #print('Binary: ',people)
        if '0' not in chain(*people) and '1' not in chain(*people):
            break
        


#print(people)

for z in range(int(input())):
    x_from,y_from,x_to,y_to = input().split()
   

    if people[int(x_from)-1][int(y_from)-1] == people[int(x_to)-1][int(y_to)-1]:
        print(ans[people[int(x_from)-1][int(y_from)-1]])
    else:
        print('neither')
