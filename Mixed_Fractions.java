import java.util.*;
public class Mixed_Fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num;
        int deno;

        while((num = sc.nextInt())!= 0 && (deno = sc.nextInt()) != 0){
            
            int div = num/deno;
            System.out.println(div+" "+(num - div*deno)+" / "+deno);
        }
    }
}
