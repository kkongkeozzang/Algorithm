import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new int[n][n];

        for(int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();

            for(int j = 0; j < charArray.length; j++) {
                tree[i][j] = Integer.parseInt(String.valueOf(charArray[j]));
            }
        }

        quadTree(0,0,n);
        System.out.println(sb);
    }

    static void quadTree(int x, int y, int size) {

        if(numCheck(x,y,size)) {
            sb.append(tree[x][y]);
            return;
        }

        int newSize = size/2;

        sb.append("(");

        quadTree(x,y,newSize);
        quadTree(x,y+newSize,newSize);
        quadTree(x+newSize,y,newSize);
        quadTree(x+newSize,y+newSize,newSize);

        sb.append(")");
    }

    static boolean numCheck(int x, int y, int size) {
        int prevNum = tree[x][y];

        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(tree[i][j] != prevNum) {
                    return false;
                }
            }
        }
        return true;
    }
}
