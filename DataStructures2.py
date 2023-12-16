while True:
    try:
        x = input()
        #print('x: ',x)
        if(not x):
            #print('done')
            exit()
        stack,queue,pqueue = False,False,False
        inn = []
        out = []
        
        for i in range(int(x)):
            b,z = input().split()

            if(b == '1'):
                inn.append(int(z))
            if(b == '2'):
                out.append(int(z))
        
        if(len(inn)==0 or len(out)==0):
            print('impossible')
            continue
        
        #Stack Check
        if(inn[::-1] == out):
            stack = True
        #Queue Check
        if(out == inn):
            queue = True
        #Priority Queue
        c = 0
        for j in out:
            if(j == max(inn)):
                inn.remove(max(inn))
                c = c+1
            if(c == len(out)):
                pqueue = True

        if((stack and queue) or (stack and pqueue) or (pqueue and queue)):
            print('not sure')
            continue
        elif(stack):
            print('stack')
            continue
        elif(queue):
            print('queue')
            continue
        elif(pqueue):
            print('priority queue')
            continue
        else:
            print('impossible')
    except EOFError:
        break
    except ValueError:
        break
