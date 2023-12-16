import java.util.*;
public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (sc.hasNext()) {
            
        
            int max= Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int x = sc.nextInt();
            ArrayList<Integer> num = new ArrayList<>();
            
            for (int j = 0; j < x; j++) {
                int y = sc.nextInt();
                num.add(x);
                if(y>max)max = y;
                if(y<min)min = y;
            }

            System.out.println("Case "+(++i)+": "+min+" "+max+" "+(max-min));
            
        }
        
    }

}
