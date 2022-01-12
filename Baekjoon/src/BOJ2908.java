import java.util.Scanner;

public class BOJ2908 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] a = String.valueOf(sc.nextInt()).toCharArray();
        char[] b = String.valueOf(sc.nextInt()).toCharArray();
        sc.close();
        char temp;
        temp = a[0];
        a[0] = a[2];
        a[2] = temp;
        temp = b[0];
        b[0] = b[2];
        b[2] = temp;
        int revA = Integer.parseInt(String.valueOf(a));
        int revB = Integer.parseInt(String.valueOf(b));
        System.out.println(Math.max(revA, revB));

    }
}
