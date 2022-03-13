import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        // w개의 방, h층 건물
        // 가까운 거리 순으로 방 배정
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int h = Integer.parseInt(st.nextToken());  // 층 수
            int w = Integer.parseInt(st.nextToken());  // 방 수
            int n = Integer.parseInt(st.nextToken());  // 몇 번째 손님
            // 6층, 12방, 10번째 손님
            // 101~601, 102~602, 103~603, 104~604, ...
            // n / h + 1 = n이 몇 호에 묵을지
            // n % h = 몇 층에 묵을지
            if(n%h == 0) {
                System.out.println(h*100+(n/h));
            } else {
                System.out.println(n%h*100+(n/h+1));
            }
        }
    }
}
