import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<String[]> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            arr.add(tmp);
        }
        Collections.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr.get(i)[0]).append(" ").append(arr.get(i)[1]).append("\n");
        }
        System.out.println(sb);
    }
}
