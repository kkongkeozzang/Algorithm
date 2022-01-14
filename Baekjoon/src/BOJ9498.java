import java.util.Scanner;

public class BOJ9498 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if(89 < n && n <= 100) {
            System.out.println("A");
        } else if (79 < n && n < 90) {
            System.out.println("B");
        } else if (69 < n && n < 80) {
            System.out.println("C");
        } else if (59 < n && n < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
