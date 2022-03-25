import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        // List에 좌표 넣기
        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            arr.add(tmp);
        }
        Collections.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) {
                    return o1[0] - o2[0];
                } else if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return 1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int[] i : arr) {
            sb.append(i[0]).append(" ").append(i[1]).append("\n");
        }
        System.out.println(sb);
    }
}
