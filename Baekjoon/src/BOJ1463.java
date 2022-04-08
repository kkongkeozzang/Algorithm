import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1463 {
    static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(recur(n,0));
    }

    static int recur(int n, int count) {
        if(n < 2) {
            return count;
        }
        return Math.min(recur(n/2, count+1+(n%2)), recur(n/3, count+1+(n%3)));
    }


}
