import java.io.*;
import java.util.*;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            set.add(bf.readLine());
        }
        List<String> ans = new ArrayList<>(set);

        ans.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String i : ans) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
