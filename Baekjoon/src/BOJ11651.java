import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        while(n --> 0) {
            int[] tmp = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            arr.add(tmp);
        }
        arr.sort((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int[] i : arr) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        System.out.println(sb);
    }
}
