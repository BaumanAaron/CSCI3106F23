from sys import stdin, stdout
n = int(stdin.readline())
strings = [stdin.readline().rstrip() for _ in range(n)]
root = list(range(n))
#print(root)
next_ = list(range(n))
#print(next_)
a = 0
for _ in range(n - 1):
    a, b = map(lambda x: int(x) - 1, stdin.readline().split())
    #print(a,b)
    r = a

        # elements to update root
    to_update = []
    while root[r] != r:
        print(root[r],r)
        to_update.append(r)
        r = root[root[r]]
       

    for i in to_update:
        root[i] = b

    root[r] = b
    next_[r] = b

i = a
for _ in range(n - 1):
    stdout.write(strings[i])
    i = next_[i]

stdout.write(strings[i])