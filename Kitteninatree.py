from collections import defaultdict
kitten = int(input())
n = 0
tree = defaultdict(set)
path = [kitten]
while(n < 101):
    root, *leaves = input().split()
    if(int(root) == -1):
        break
    for leaf in leaves:
        tree[root].add(int(leaf))

    n+=1
target = kitten
source = int(list(tree.keys())[0])

while(source not in path):
    for k in tree.keys():
        if(target in tree[k]):
            target = int(k)
            path.append(target) 
    
print(*path)