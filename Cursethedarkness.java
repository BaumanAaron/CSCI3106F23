import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cursethedarkness {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < m; i++) {
            boolean light = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            double book_x = Double.parseDouble(st.nextToken());
            double book_y = Double.parseDouble(st.nextToken());

            int n_c = Integer.parseInt(br.readLine());
            double[] candle_x = new double[n_c];
            double[] candle_y = new double[n_c];

            
            for (int j = 0; j < n_c; j++) {
                st = new StringTokenizer(br.readLine());
                candle_x[j] = Double.parseDouble(st.nextToken());
                candle_y[j] = Double.parseDouble(st.nextToken());

                if (distance(book_x, book_y, candle_x[j], candle_y[j]) <= 8) {
                    light = true;
                }
            }

            if (light) {
                System.out.println("light a candle");
            } else {
                System.out.println("curse the darkness");
            }
        }
    }

    public static double distance(double bx, double by, double cx, double cy) {
        return Math.sqrt(Math.pow((bx - cx), 2) + Math.pow((by - cy), 2));
    }
}
