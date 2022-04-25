import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667 {
    static int[][] apart;
    static boolean[][] checked;
    static int[] count;
    static int countNum = 0;
    static int n;


    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        apart = new int[n][n];
        checked = new boolean[n][n];
        count = new int[n*n];

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < n; j++) {
                apart[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(apart[i][j] != 0 && !checked[i][j]) {
                    countNum++;
                    bfs(i,j);
                }
            }
        }

        Arrays.sort(count);
        sb.append(countNum).append("\n");

        for(int i : count) {
            if(i != 0) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    static void bfs(int x, int y) {
        Queue<Integer[]> q = new LinkedList<>();
        checked[x][y] = true;
        q.offer(new Integer[] {x,y});
        count[countNum]++;

        while(!q.isEmpty()) {
            Integer[] target = q.poll();
            int cX = target[0];
            int cY = target[1];

            for(int i = 0; i < dx.length; i++) {
                int tX = cX + dx[i];
                int tY = cY + dy[i];

                if(tX >= 0 && tY >= 0 && tX < n && tY < n) {
                    if(apart[tX][tY] == 1 && !checked[tX][tY]) {
                        q.offer(new Integer[] {tX, tY});
                        checked[tX][tY] = true;
                        count[countNum]++;
                    }
                }
            }

        }
    }
}
