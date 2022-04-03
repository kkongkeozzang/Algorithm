import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

    static int arrSize, r, c;
    static int count;
    static int[][] arr;
    static int[] dx, dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dx = new int[] {0,0,1,1};
        dy = new int[] {0,1,0,1};

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arrSize = (int)Math.pow(2, n);
        recur(arrSize, 0, 0);
    }

    static void recur(int size, int x, int y) {
        if(size == 2) {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                count++;
                if(nx == r && ny == c) {
                    System.out.println(count-1);
                    System.exit(0);
                }
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx1 = x + size/2 * dx[i];
            int nx2 = x + size/2 * (dx[i]+1) - 1;
            int ny1 = y + size/2 * dy[i];
            int ny2 = y + size/2 * (dy[i]+1) - 1;

            if( r >= nx1 && r <= nx2 && c >= ny1 && c <= ny2) {
                count += size/2 * size/2 * i;
                recur(size/2, nx1, ny1);
            }
        }
    }
}
