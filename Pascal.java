/**
 * Pascal
 */
import java.util.*;
public class Pascal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n == 1){
            System.out.println("0");
            System.exit(0);
        }

        for (int i = 2; i < Math.sqrt(n)+1; i++) {
            if(n % i == 0){
                System.out.println(n-(n/i));
                System.exit(0);
            }
        }

        System.out.println(n-1);
    }
}