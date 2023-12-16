
def order(a):
    copy = sorted(a.copy())
    #print('original',a)
    #print('copy',copy)
    if (copy == a):
        return 'INCREASING'
    copy.reverse()
    #print('reverse copy',copy)
    if (copy == a):
        return 'DECREASING'
    else:
        return 'NEITHER'



name = []
for i in range(int(input())):
    name += input().split()


print(order(name))