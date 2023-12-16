from collections import defaultdict,Counter

words_list = Counter()
userlog = defaultdict(set)

for i in range(int(input())):
    name, *words = input().split()

    for w in words:
        userlog[name].add(w)
        words_list[w] += 1

all_said = list(set.intersection(*userlog.values()))


if all_said:
    print('\n'.join(sorted(all_said,key=lambda x: (-words_list[x],x))))
else:
    print('ALL CLEAR')



