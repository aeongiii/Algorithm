import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        for(;;){
            int a=s.nextInt();
            int b=s.nextInt();
            if(a==0&&b==0) break;
            if(a>=b&&a%b==0) System.out.println("multiple");
            else if(b>=a&&b%a==0) System.out.println("factor");
            else System.out.println("neither");
        }
    }
}