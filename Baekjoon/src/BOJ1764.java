import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int count = 0;
        // 듣도 못한 사람은 HashSet에 넣고, 있는지 확인 후 출력
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for(int i = 0; i < m; i++) {
            String target = br.readLine();
            if(set.contains(target)) {
                ans.add(target);
                count++;
            }
        }
        Collections.sort(ans);
        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for(String name : ans) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
