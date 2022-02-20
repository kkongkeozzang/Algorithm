import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1929 {

    public static void printPrimeArr(int start, int end) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 배열을 생성하여 초기화
        int[] arr = new int[end+1];
        for(int i = 2; i <= end; i++) {
            arr[i] = i;
        }

        // 에라토스테네스의 체 구현
        for(int i = 2; i <= end; i++) {
            if(arr[i] == 0) {
                continue; // 이미 지워진 수라면 건너뛰기
            }
            for(int j = 2*i; j <= end; j += i) {
                // 자기 자신은 지우지 않고, 다음 배수부터 끝까지 지우기
                arr[j] = 0;
            }
        }
        // 남아있는 수 모두 출력
        for(int i = start; i <= end; i++) {
            if(arr[i] != 0) {
                bw.write(arr[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        printPrimeArr(m,n);
    }
}
