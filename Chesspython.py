#Creates a list of the diagonals moves from given position
def one_move(x, y):
    diagonals = set()
    for i in range(1, 9):
        for j in range(1, 9):
            if abs(i-x) == abs(j-y):
                square = (i, j)
                diagonals.add(square)
    return diagonals


num = int(input())
dict = {'A': 1, 'B': 2, 'C': 3, 'D': 4, 'E': 5, 'F': 6, 'G': 7, 'H': 8}
dict_reverse = {v: k for k, v in dict.items()}


for i in range(num):
    pos = input().split()
    source = (dict[pos[0]], int(pos[1]))
    destination = (dict[pos[2]], int(pos[3]))

    #0 moves needed
    if source == destination:
        print(str(0) + " " + pos[0] + " " + pos[1])

    else:
        
        source_one_move_list = one_move(source[0], source[1])

        #Checks for desination in diagonal move list 
        if destination in source_one_move_list:
            print(str(1) + " " + pos[0] + " " + pos[1] + " " + pos[2] + " " + pos[3])

        else:
            #Creates diagonal move list from destination
            destination_one_move_list = one_move(destination[0], destination[1])

            #Finds the intersections of the diagonals
            intersect = source_one_move_list.intersection(destination_one_move_list)
            if not intersect:
                print("Impossible")
            else:
                move = intersect.pop()
                print(str(2) + " " + pos[0] + " " + pos[1] + " " +dict_reverse[move[0]] + " " + str(move[1]) + " " + pos[2] + " " + pos[3])