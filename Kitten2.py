
def find_path(root,tree,kitten):
    path = []

    def dfs(node,kitten):
        path.append(node)
        if(node == kitten):
            print(*path[::-1])
        for child in tree[node]:
            dfs(child,kitten)
        path.pop()
    dfs(root,kitten)
    
        


from collections import defaultdict
n = 0
kitten = input()
tree = defaultdict(set)
while(n < 101):
    root, *leaves = input().split()
    if(int(root) == -1):
        break
    for leaf in leaves:
        tree[root].add(leaf)

    n+=1
target = kitten
source = list(tree.keys())[0]

find_path(source,tree,kitten)