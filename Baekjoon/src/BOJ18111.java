import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for(int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
                min = Math.min(arr[i][j], min);
                max = Math.max(arr[i][j], max);
            }
        }

        int time = Integer.MAX_VALUE;
        int height = -1;
        for(int k = min; k <= max; k++) {
            int tmpB = b;
            int tmp = 0;
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < arr[0].length; j++) {
                    if(arr[i][j] > k) {
                        tmp += (arr[i][j]-k)*2;
                        tmpB += arr[i][j]-k;
                    } else if (arr[i][j] < k ){
                        tmp += k - arr[i][j];
                        tmpB -= k - arr[i][j];
                    }
                }
            }
            if(tmpB < 0) {
                continue;
            }
            if(time == tmp) {
                height = Math.max(height, k);
            } else {
                if(tmp < time) {
                    height = k;
                }
                time = Math.min(tmp, time);
            }
        }
        System.out.println(time + " " + height);



    }
}
