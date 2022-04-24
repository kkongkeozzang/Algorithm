import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2630 {
    static int[][] paper;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        paper = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void divide(int x, int y, int size) {
        if(isColorSame(x,y,size)) {
            return;
        }

        int newSize = size/2;

        divide(x,y,newSize);
        divide(x+newSize,y,newSize);
        divide(x,y+newSize,newSize);
        divide(x+newSize,y+newSize,newSize);
    }

    static boolean isColorSame(int x, int y, int size) {
        int color = paper[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(color != paper[i][j]) {
                    return false;
                }
            }
        }

        if(color == 1) {
            blue++;
        } else {
            white++;
        }
        return true;
    }
}
