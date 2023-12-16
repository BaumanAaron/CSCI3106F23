from collections import defaultdict
cities = tree = defaultdict(set)

for i in range(int(input())):
    n,m = input().split()
    for j in range(int(m)):
        a,b = input().split()
        cities[a].add(b)

    print(int(n)-1)
