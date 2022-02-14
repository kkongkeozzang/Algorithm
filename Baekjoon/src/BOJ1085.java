import java.io.*;
import java.util.StringTokenizer;

public class BOJ1085 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] arr = new int[4];
        arr[0] = x;
        arr[1] = w-x;
        arr[2] = y;
        arr[3] = h-y;

        int minNum = 1001;
        for(int i = 0; i<4; i++) {
            if(arr[i] > 0) {
                if(minNum>arr[i]) {
                    minNum = arr[i];
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(minNum));
        bw.flush();
        bw.close();

    }
}
