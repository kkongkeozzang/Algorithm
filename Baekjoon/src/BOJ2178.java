import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

    // bfs -> queue를 사용
    static int[][] maze;  // 0과 1 입력할 배열
    static boolean[][] visited;  // 방문 여부
    static int n;
    static int m;

    static int[] dx = new int[] {-1,1,0,0};  // 인접한 칸으로 이동 좌표
    static int[] dy = new int[] {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];  // 인덱스 0일 때 1의 좌표를 가짐

        // 0과 1 입력하기
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];

        bfs(0,0);
        System.out.println(maze[n-1][m-1]);  // 1씩 크게 작용하므로 1을 빼줘야한다
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});  // queue에 좌표 집어넣기

        while(!q.isEmpty()) {
            int location[] = q.poll();  // 현재 좌표
            visited[x][y] = true;  // 방문 체크

            for(int i = 0; i < 4; i++) {
                int r = location[0] + dx[i];  // 움직이는 좌표
                int c = location[1] + dy[i];

                if(r >= 0 && c >= 0 && r < n && c < m) {  // 범위 체크
                    if(maze[r][c] != 0 && !visited[r][c]) {  // 0이 아니고(움직일 수 있고) 방문하지 않았다면
                        q.offer(new int[] {r,c});  // queue에 좌표 집어넣기
                        visited[r][c] = true;  // 방문 체크
                        maze[r][c] = maze[location[0]][location[1]] + 1;  // 새로운 좌표에 기존좌표값 + 1
                    }
                }
            }
        }
    }
}
