/**
 * Judging_Moose
 */
import java.util.*;
public class Judging_Moose {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        

        if(a == 0 && b == 0){
        System.out.println("Not a moose");
        }else{       
            if(a == b){
                if(a>b)System.out.println("Even "+ a*2);
                else System.out.println("Even "+b*2);
            }else{
                if(a>b)System.out.println("Odd "+ a*2);
                else System.out.println("Odd "+b*2);
            }
        }

    }
}