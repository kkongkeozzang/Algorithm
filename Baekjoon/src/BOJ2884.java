import java.util.Scanner;

public class BOJ2884 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        if(m-45<0) {
            if(h == 0) {
                h = 23;
            } else {
                h--;
            }
            m += 15;
        }else {
            m -= 45;
        }
        System.out.println(h + " " + m);
    }
}
