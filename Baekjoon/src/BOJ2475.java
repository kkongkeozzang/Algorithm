import java.util.Scanner;

public class BOJ2475 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();

        int ans = 0;
        ans += a*a;
        ans += b*b;
        ans += c*c;
        ans += d*d;
        ans += e*e;

        System.out.println(ans%10);

    }
}
