import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050 {
    public static int fact(int num) {
//        if(num <= 1) {
//            return 1;
//        } else {
//            return fact(num-1)*num;
//        }
        int ans = 1;
        if(num <= 1) {
            return 1;
        } else {
            for(int i = num; i >= 1; i--) {
                ans *= i;
            }
            return ans;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(fact(n)/(fact(k)*fact(n-k)));
    }
}
