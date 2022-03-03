import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        while(t --> 0) {
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            // k층 n호 (k는 0부터 시작, n은 1부터 시작)
            int[] room = new int[n+1]; // 0은 버리기
            for(int i = 1; i <= n; i++) {  // 0층 방에 사람 채우기
                room[i] = i;  // 0층 = {0, 1, 2, 3}
            }
            for(int i = 1; i <= k; i++) {  // 층 수 올라가기
                for(int j = 1; j <= n; j++) {  // 방에 사람 채우기
                    room[j] += room[j-1];
                }
            }
            System.out.println(room[n]);
        }
    }
}
