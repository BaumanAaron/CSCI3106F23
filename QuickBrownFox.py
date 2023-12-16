for i in range(int(input())):
    alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}
    inp = input()
    inl = set([x.lower() for x in inp if x.isalpha()])
    #print('input:', inl)
    diff = list(alphabet.difference(inl))
    
    s_diff = sorted(diff)
    #print(s_diff)
    if (not diff):
        print('pangram')
    else:
        print('missing ',*s_diff,sep='')
        