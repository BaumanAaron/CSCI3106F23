/**
 * Canadians
 */
import java.util.*;
public class Canadians {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.substring(input.length()-3,input.length()).equals("eh?")){
            System.out.println("Canadian!");
        }else{
            System.out.println("Imposter!");

        }
        
        
    
    
}
}