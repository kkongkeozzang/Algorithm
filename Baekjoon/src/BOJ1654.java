import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            arr.add(Integer.parseInt(bf.readLine()));
        }
        long max = 0;
        for(int i : arr) {
            if(max < i) {
                max = i;
            }
        }
        long start = 1;
        long end = max;
        while(start <= end) {
            long count = 0;
            long mid = (start+end)/2;
            for(int i : arr) {  // 랜선 잘라 갯수 구하기
                count += i/mid;
            }
            if(count >= n) {  // 갯수를 충족할 때, 최대 길이인지 확인
                start = mid+1;
            } else {  // 갯수가 작으면 기준을 내림
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
