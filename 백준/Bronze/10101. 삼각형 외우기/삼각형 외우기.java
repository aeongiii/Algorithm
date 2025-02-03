import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int each1 = sc.nextInt();
        int each2 = sc.nextInt();
        int each3 = sc.nextInt();
 
        if(each1==60 && each2==60 && each3==60){
            System.out.println("Equilateral");
        } else if (each1+each2+each3 == 180) {
            if(each1 == each2){
                System.out.println("Isosceles");
            } else if (each1 == each3) {
                System.out.println("Isosceles");
            } else if (each2 == each3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else if (each1+each2+each3 != 180) {
            System.out.println("Error");
        }
 
    }
}