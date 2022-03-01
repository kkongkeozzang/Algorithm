import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        // 24 = 6*4
        // 18 = 6*3
        // 6, 6*12
        // n/최대공약수 끼리 곱하면 최소공배수 나옴
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        // 최대공약수 구하기
        int max = 1;
        int num = 2;
        while(Math.min(a,b)/(double)num >= 1) {
            if(a%num == 0 && b%num == 0) {
                max *= num;
                a /= num;
                b /= num;
                num = 1; // 초기화
            }
            num++;
        }
        sb.append(max).append("\n");
        sb.append(a*b*max);
        System.out.println(sb);
    }
}
