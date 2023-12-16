import java.util.*;
public class Simon_Says {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        sc.nextLine();

        for (int i = 0; i < num; i++) {
            String simon = sc.nextLine();//                               0123456789
            //System.out.println(simon.substring(0, 10));
            if (simon.startsWith("Simon says"))
            System.out.println(simon.substring(10));
        }
        }
    }

