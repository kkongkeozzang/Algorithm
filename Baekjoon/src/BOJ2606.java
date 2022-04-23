import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int[][] com;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        com = new int[n+1][n+1];
        checked = new boolean[n+1];

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            com[a][b] = 1;
            com[b][a] = 1;
        }

        bfs(1);

    }

    static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        checked[x] = true;
        int count = 0;

        while(!q.isEmpty()) {
           int target = q.poll();

           for(int i = 1; i < com.length; i++) {
               if(com[target][i] == 1 && !checked[i]) {
                   q.offer(i);
                   checked[i] = true;
                   count++;
               }
           }
        }
        System.out.println(count);
    }
}
