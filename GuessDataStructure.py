import sys
from queue import Queue


def main():
    for line in sys.stdin:
        n = int(line.strip())
        stack, queue, pqueue = [], Queue(), []
        is_stack, is_queue, is_pqueue = True, True, True

        for _ in range(n):
            command, value = map(int, input().split())
            if command == 1:
                stack.append(value)
                queue.put(value)
                pqueue.append(value)
            else:
                if not stack:
                    is_stack = is_queue = is_pqueue = False
                    continue

                if stack.pop() != value:
                    is_stack = False
                if queue.get() != value:
                    is_queue = False
                max_value = max(pqueue)
                if max_value != value:
                    is_pqueue = False
                pqueue.remove(max_value)
    
        if is_stack + is_queue + is_pqueue == 0:
            print("impossible")
        elif is_stack + is_queue + is_pqueue > 1:
            print("not sure")
        elif is_stack:
            print("stack")
        elif is_queue:
            print("queue")
        elif is_pqueue:
            print("priority queue")

if __name__ == "__main__":
    main()