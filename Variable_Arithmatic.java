import java.util.*;
public class Variable_Arithmatic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        while () {
            
        }
        

        //while(sc.hasNextLine() != "0"){
            String input = sc.nextLine();
            if(input.contains(" = ")){
                System.out.println("has =");
                String[] strSplit = input.split(" = ");
                ArrayList<String> var = new ArrayList<String>(Arrays.asList(strSplit));
                System.out.println(var.toString());
                int value = Integer.parseInt(var.get(1));
                hashMap.put(var.get(0),value);
            }


            if(input.contains(" + ")){
                System.out.println("contains +");
                String[] strSplit = input.split(" + ");
                ArrayList<String> arith = new ArrayList<String>(Arrays.asList(strSplit));
                System.out.println(arith.size());
                
                for (int i = 0; i < arith.size(); i++) {
                    System.out.println(arith.get(i));
                    hashMap.put(arith.get(i), 0);
                }

            }
        //}
            
            System.out.println("Hashmap: " + hashMap.toString());
        
    }
}
