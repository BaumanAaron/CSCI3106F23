from collections import defaultdict

def find_path(root,tree,kitten):
    path = []
    visited = []
    def dfs(node,kitten):
        path.append(node)
        visited.append(node)
        #print(path)
        if(node == kitten):
            print(*path[::-1])
            exit(0)
        for child in tree[node]:
            if(child not in visited):
                dfs(child,kitten)
        path.pop()
    dfs(root,kitten)

map = defaultdict(set)
all_places = []

for i in range(int(input())):
    root, *leaves = input().split()
    for leaf in leaves:
        map[root].add((leaf))
        all_places.append(leaf)
        all_places.append(root)

source, destination = input().split()


diff = set(all_places) - map.keys()
missing_map = defaultdict(set)

find_path(destination,map,source)

for d in diff:
    for k in map.keys():
        if(d in map[k]):
            missing_map[d].add(k)
    
merge_map = {**map,**missing_map}

find_path(destination,merge_map,source)
print('no route found')