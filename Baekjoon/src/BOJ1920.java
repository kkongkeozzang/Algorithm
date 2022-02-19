import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        String[] arr = bf.readLine().split(" ");
        int[] intArr = new int[arr.length];
        for(int i = 0; i < n; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        int m = Integer.parseInt(bf.readLine());
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i = 0; i < m; i++) {
            int start = 0;
            int end = n-1;
            int target = Integer.parseInt(st.nextToken());
            while(true){
                int mid = (start + end)/2;
                if(intArr[mid] > target) { // 중간값보다 target이 작으면
                    end = mid-1;
                } else if(intArr[mid] < target) { // 중간값보다 target이 크면
                    start = mid+1;
                } else { // 찾으면
                    bw.write("1\n");
                    break;
                }
                if(start > end) { // 못 찾는 경우
                    bw.write("0\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
