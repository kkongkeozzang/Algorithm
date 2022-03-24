import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] counting = new int[10001];

        // counting 하기
        for(int i = 0; i < n; i++) {
            counting[Integer.parseInt(bf.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        // 정렬하기
        for(int i = 1; i < counting.length; i++) {
            while(counting[i] > 0) {
                sb.append(i).append("\n");
                counting[i]--;
            }
        }
        System.out.println(sb);
    }
}
