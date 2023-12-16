from sys import stdin
from sys import stdout

n = int(stdin.readline())

string = [stdin.readline().rstrip() for _ in range(n)]

a=0
for _ in range(n-1):
    a,b = map(lambda x: int(x)-1, stdin.readline().split())
    
    
    string[a] += string[b]
    


stdout.write(string[a])