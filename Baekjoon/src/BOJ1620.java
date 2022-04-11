import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        HashMap<Integer,String> mapInt = new HashMap<>();
        HashMap<String,Integer> mapStr = new HashMap<>();
        for(int i = 1; i <= n; i++) {  // 도감 입력
            String s = br.readLine();
            mapInt.put(i,s);
            mapStr.put(s,i);
        }
        for(int i = 0; i < m; i++) {  // 문제 출력
            String s = br.readLine();
            if(s.charAt(0) <= '9') {  // 숫자 입력이라면
                String target = mapInt.get(Integer.parseInt(s));
                sb.append(target).append("\n");
            } else {  // 문자 입력이라면
                int target = mapStr.get(s);
                sb.append(target).append("\n");
            }
        }
        System.out.println(sb);
    }
}
