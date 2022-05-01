import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {
    static int[][][] tomatoes;
    static int m;
    static int n;
    static int h;

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];
        queue = new LinkedList<>();

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomatoes[i][j][k]==1) {
                        queue.add(new int[] {i,j,k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        while(!queue.isEmpty()) {
            int[] target = queue.poll();
            int z = target[0];
            int x = target[1];
            int y = target[2];

            for(int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<n && ny<m && nz<h) {
                    if(tomatoes[nz][nx][ny] == 0) {
                        queue.add(new int[] {nz,nx,ny});

                        tomatoes[nz][nx][ny] = tomatoes[z][x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(tomatoes[i][j][k]==0) {
                        return -1;
                    }
                    result = Math.max(result, tomatoes[i][j][k]);
                }
            }
        }

        if(result==1) {
            return 0;
        } else {
            return result-1;
        }

    }
}
