import java.util.*;
public class Babelfish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean val = true;
        HashMap<String,String> Dict=new HashMap<String,String>();

        while(val){
            input = sc.nextLine();
            if(input.equals(" ")){
                val = false;
                break;
            }
            String[] def = input.split(" ");
            Dict.put(def[1], def[0]);
            System.out.println(def[1]+"-"+def[0]);
            
        }
        System.out.println("loop broke");
        for(Map.Entry m : Dict.entrySet()){    
            System.out.println(m.getKey()+" "+m.getValue());    
           }  
        
    }
}
