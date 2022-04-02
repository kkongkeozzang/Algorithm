import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] map;  // 땅
    static boolean[][] check;  // 체크여부
    static int count = 0; // 지렁이 수
    public static int[] dx = {0,0,1,-1};  // 위,아래,양옆 좌표
    public static int[] dy = {1,-1,0,0};
    static int m,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            check = new boolean[m][n];
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            // 탐색하기
            for(int x = 0; x < m; x++) {
                for(int y = 0; y < n; y++) {
                    if(map[x][y] == 1 && !check[x][y]) {  // 배추가 있고, 체크가 안되어있으면 +1
                        count++;
                        dfs(x,y);  // 다시 탐색
                    }
                }
            }
            // 탐색이 끝나면 sb에 저장
            sb.append(count).append("\n");
            count = 0; // 초기화
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y) {
        check[x][y] = true;  // 탐색 완료

        for(int i = 0; i < 4; i++) {  // 4방면 탐색
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n) {  // 범위 안에서
                if(map[nx][ny] == 1 && !check[nx][ny]) {  // 조건을 만족하면 그냥 패스
                    dfs(nx,ny);
                }
            }
        }
    }
}
