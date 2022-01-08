import java.util.Scanner;

public class BOJ2577 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        long ans = a*b*c;
        char[] arr = String.valueOf(ans).toCharArray();
        int[] ansArr = new int[10];
        for (char value : arr) {
            int num = Integer.parseInt(value + "");
            ansArr[num] += 1;
        }
        for(int i : ansArr) {
            System.out.println(i);
        }
    }
}
