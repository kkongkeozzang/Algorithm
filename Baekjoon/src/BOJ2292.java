import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        // 1(1) -> 1개 : 6*0
        // 2~7(6) -> 2개 : 6*0+1부터 6*1개
        // 8~19(12) -> 3개 : 1+6+1부터 6*2개
        // 20~37(18) -> 4개 : 1+6+12+1부터 6*3개
        // 38~61(24) -> 5개 : 1+6+12+18+1부터 6*4개
        int bee = 1;
        int count = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        while(n > 0) {
            n-= bee;
            count++;
            bee = 6*count;
        }
        System.out.println(count);
    }
}
