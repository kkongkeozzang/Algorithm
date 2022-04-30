import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = x;
            int tmpY = x;

            for(int i = 0; i < n; i++) {
                int ty = tmpY % n == 0 ? n : tmpY%n;
                if(ty == y) {
                    break;
                }

                tmpY = ty + m;
                cnt += m;
            }
            sb.append(cnt > lcm(m,n) ? "-1" : cnt);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }
}
