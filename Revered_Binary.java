import java.util.*;
public class Revered_Binary {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int reversednum;
        // Creating Stack Object Vector
        Stack<Integer> st = new Stack<>();
        Stack<Integer> reversed = new Stack<>();
        // Number Should be positive
        while (num > 0) {
           
            // Pushing numbers inside stack that
            // are divisible by 2
            st.push(num % 2);
            // Dividing number by 2
            num = num / 2;
        }

        int decimalValue = 0;
        int position = 0;
        while (!st.isEmpty()) {
            int binaryDigit = st.pop();
            if (binaryDigit == 1) {
                decimalValue += Math.pow(2, position);
            }
            position++;
        }
        System.out.println(decimalValue);
    
 
        


}
}