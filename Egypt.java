import java.util.*;

public class Egypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        while (a != 0 && b != 0 && c != 0) {
            ArrayList<Integer> tri = new ArrayList<>();
            tri.add(a);
            tri.add(b);
            tri.add(c);

            tri.sort(null);
            //System.out.println(tri);

            if(tri.get(2)*tri.get(2) == tri.get(0)*tri.get(0) + tri.get(1)*tri.get(1)){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }


            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            
        }
    }
}
