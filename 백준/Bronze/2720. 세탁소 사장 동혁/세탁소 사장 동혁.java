import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int q = 25;
        int d = 10;
        int n = 5;
        int p = 1;
        for (int i = 0; i < t; i++) {
            int c = sc.nextInt();
            System.out.print(c / q + " ");
            c = c % q;
            System.out.print(c / d + " ");
            c = c % d;
            System.out.print(c / n + " ");
            c = c % n;
            System.out.println(c / p);
        }

        sc.close();
    }
}