import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        // 몸무게 : x , 키 : y -> (x,y)
        // 자신보다 더 큰 덩치 사람 k명 -> 그 사람의 덩치 등수는 k+1
        // 첫줄 : 전체 사람 수 n
        // n개의 줄 : x y
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<int[]> arr = new ArrayList<>();
        int[] count = new int[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
        }
        // 46,155 55,185 58,183 60,175 88,186
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr.get(i)[0] < arr.get(j)[0]) {
                    if(arr.get(i)[1] < arr.get(j)[1]) {
                      count[i] += 1;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i : count) {
            i += 1;
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
