import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1389 {
    static int n;  // 유저 수
    static int m;  // 친구 관계 수
    static int[] answerNum;  // 정답 친구 번호
    static int[] minDistance;  // 친구 최단 경로
    static int[][] distance;  // 최단거리
    static int INF = 5001;  // Integer.MAX_VALUE로 할 경우 더해주는 과정에서 오버될 수 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new int[n+1][n+1];

        // 초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = INF;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            distance[x][y] = 1;
            distance[y][x] = 1;
        }

        // 플로이드 워셜 알고리즘
        floyd();

        // 출력
        int[] answer = new int[n+1];
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <=n; j++) {
                sum += distance[i][j];
            }
            answer[i] = sum;
            if(sum < min) {
                min = sum;
            }
        }
        for(int i = 1; i <=n ; i++) {
            if(answer[i] == min) {
                System.out.println(i);
                return;
            }
        }
    }
    static void floyd() {
        for(int k = 1; k <= n; k++) {  // 거쳐가는 중간 지점 노드
            for(int i = 1; i <= n; i++) {  // 시작 노드
                for(int j = 1; j <= n; j++) {  // 도착 노드
                    // i-k-j 경로와 i-j 경로 중 최단 경로
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }

    }
}
