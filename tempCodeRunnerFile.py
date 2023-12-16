while(source not in path):
    for k in tree.keys():
        if(target in tree[k]):
            target = int(k)
            path.append(target) 
    
print(*path)