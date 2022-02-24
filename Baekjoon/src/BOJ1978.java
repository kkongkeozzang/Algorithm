import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {
    // 주어진 수가 소수인지 판별하는 메소드
    public static boolean isPrime(int num) {
        // 제곱근 만들기
        int sq = (int)Math.sqrt(num);
        // 2부터 sq까지 하나라도 나누어 떨어지면 소수가 아님
        for(int i = 2; i < sq + 1; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        int count = 0;
        // 주어진 수의 제곱근의 약수들로 나누어 떨어지지 않으면 소수
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        while(n --> 0) {
            int target = Integer.parseInt(st.nextToken());
            if(target == 1) {
                continue;
            }
            if(isPrime(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
