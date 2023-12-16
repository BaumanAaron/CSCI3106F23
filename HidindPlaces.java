
/**
 * HidindPlaces
 */
import java.util.*;

public class HidindPlaces {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Handling Input
        int n_in = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n_in; i++) {
            // Chess Board
            int board[][] = { { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
                    { -1, -1, -1, -1, -1, -1, -1, -1, -1 } };
            int moves = 0;
            ArrayList<String> HidingPlaces = new ArrayList<>();
            String init_loc = sc.nextLine();
            //System.out.println("let: " + init_loc.charAt(0) + " num: " + init_loc.charAt(1));
            
            int start[] = {let_to_num(init_loc.charAt(0)),Integer.parseInt(init_loc.substring(1))};
            board[let_to_num(init_loc.charAt(0))][Integer.parseInt(init_loc.substring(1))] = 0;
            // Finds Hiding Places
            int played[][] = BFS(board, start);

            int Max_Move = getMaxMove(played);


            for (int c = 8; c > 0; c--) {
                for (int r = 1; r < 9; r++) {
                    if (played[r][c] == Max_Move) {
                        StringBuilder sq = new StringBuilder();
                        sq.append(num_to_let(r));
                        sq.append(c);
                        HidingPlaces.add(sq.toString());

                    }
                }
            }
            //System.out.println("\n-----------------------------");
            // Prints Answers
            System.out.print(Max_Move);
            for (String string : HidingPlaces) {
                System.out.print(" " + string);
            }
            System.out.println();
        }

    }

    public static int getMaxMove(int[][] numbers) {
        int maxMove = numbers[0][0];
        for (int j = 0; j < numbers.length; j++) {
            for (int i = 0; i < numbers[j].length; i++) {
                if (numbers[j][i] > maxMove) {
                    maxMove = numbers[j][i];
                }
            }
        }
        return maxMove;
    }

    public static int[][] BFS(int[][] board, int[] pos) {
        // x and y direction, where a knight can move
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        // queue for storing states of knight in board
        Queue<cell> q = new LinkedList<>();

        // push starting position of knight with 0 distance
        q.add(new cell(pos[0], pos[1], 0));

        cell t;
        int x, y;
        boolean visit[][] = new boolean[9][9]; // default initialized to false

        // visit starting state
        visit[pos[0]][pos[1]] = true;

        // loop until we have one element in queue
        while (!q.isEmpty()) {
            t = q.poll();

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y) && !visit[x][y]) {
                    visit[x][y] = true;
                    q.add(new cell(x, y, t.move + 1));
                    board[x][y] = t.move+1;
                }
            }
        }

        return board;
    }

    static boolean isInside(int x, int y) {
        if (x >= 1 && x <= 8 && y >= 1 && y <= 8)
            return true;
        return false;
    }

    public static int let_to_num(char let) {
        switch (let) {
            case 'a':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'd':
                return 4;
            case 'e':
                return 5;
            case 'f':
                return 6;
            case 'g':
                return 7;
            default:
                return 8;
        }
    }

    public static String num_to_let(int num) {
        switch (num) {
            case 1:
                return "a";
            case 2:
                return "b";
            case 3:
                return "c";
            case 4:
                return "d";
            case 5:
                return "e";
            case 6:
                return "f";
            case 7:
                return "g";
            default:
                return "h";
        }
    }

    static class cell {
        int x, y;
        int move;

        public cell(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.move = dis;
        }
    }
}