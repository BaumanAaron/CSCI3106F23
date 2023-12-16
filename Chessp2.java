import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Chessp2
 */
public class Chessp2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num;
        int y_midpoint_1 = 0, y_midpoint_2 = 0;
        // String[] bcksq =
        // {"A1","A3","A5","A7","C1","C3","C5","C7","E1","E3","E5","E7","G1","G3","G5","G7"};
        String translate = "ABCDEFGH";
        num = sc.nextInt();
        sc.nextLine();

        for (int j = 0; j < num; j++) {

            // Storing Input
            String init_x_let, final_x_let, parse_init_y, parse_final_y;
            int init_y, final_y;
            init_x_let = sc.next();
            parse_init_y = sc.next();
            init_y = Integer.parseInt(parse_init_y);
            final_x_let = sc.next();
            parse_final_y = sc.next();
            final_y = Integer.parseInt(parse_final_y);

            // Strings for output
            String intial = init_x_let + " " + init_y;
            String end = final_x_let + " " + final_y;

            String intial1 = init_x_let + init_y;
            String end1 = final_x_let + final_y;
            // System.out.println("----------------"+intial1+end1);
            // System.out.println(intial +" "+end);

            // Making x a number
            int init_x = translate.indexOf(init_x_let) + 1;
            int final_x = translate.indexOf(final_x_let) + 1;

            // Finding sloped
            int init_intercept_pos = calc_b(init_x, init_y, 1);
            int init_intercept_neg = calc_b(init_x, init_y, -1);
            int final_intercept_pos = calc_b(final_x, final_y, 1);
            int final_intercept_neg = calc_b(final_x, final_y, -1);

            int x_midpoint_1 = (final_intercept_neg - init_intercept_pos) / 2;
            int x_midpoint_2 = (init_intercept_neg - final_intercept_pos) / 2;

            // Determining which slope if within the board
            int t1 = calc_y(x_midpoint_1, 1, init_intercept_pos);
            if (t1 < 9 && t1 > 0) {
                y_midpoint_1 = t1;
            } else {
                y_midpoint_1 = calc_y(x_midpoint_1, -1, init_intercept_neg);
            }

            // Determining which slope if within the board
            int t2 = calc_y(x_midpoint_2, 1, final_intercept_pos);
            if (t2 < 9 && t2 > 0) {
                y_midpoint_2 = calc_y(x_midpoint_2, -1, final_intercept_neg);
                y_midpoint_2 = t2;
            } else {
                y_midpoint_2 = t2;
            }

            // System.out.println("________________________________________");
            if (intial.equals(end)) {
                System.out.println("0 " + init_x_let + " " + init_y);
            } else if (((init_x + init_y) % 2 == 1 && (final_x + final_y) % 2 == 0)
                    || ((init_x + init_y) % 2 == 0 && (final_x + final_y) % 2 == 1)
                    || init_x < 1 || init_x > 8 || final_x < 1 || final_y > 8) {
                System.out.println("Impossible");
            } else if (init_intercept_pos == final_intercept_pos || init_intercept_neg == final_intercept_neg) {
                System.out.println("1 " + intial + " " + end);
            } else if ((x_midpoint_2 > 0 && x_midpoint_2 < 9)) {
                char ans = translate.charAt(x_midpoint_2 - 1);
                // int y_midpoint_2 = y(x_midpoint_2,1,final_intercept_pos);
                System.out.println("2 " + intial + " " + ans + " " + y_midpoint_2 + " " + end);
            } else if ((x_midpoint_1 > 0 && x_midpoint_1 < 9)) {
                char ans = translate.charAt(x_midpoint_1 - 1);
                // int y_midpoint_1 = y(x_midpoint_1,1,init_intercept_pos);
                // System.out.println(x_midpoint_1);
                System.out.println("2 " + intial + " " + ans + " " + y_midpoint_1 + " " + end);
            }

        }

    }

    public static int calc_b(int x, int y, int m) {

        int b = y - (m * x);

        return b;
    }

    public static int calc_y(int x, int m, int b) {
        int y = m * x + b;
        return y;
    }
}