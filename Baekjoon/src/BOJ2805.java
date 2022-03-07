import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        // m보다 작으면 0
        // m보다 크면 x-m 만큼 가져감
        // 최대로 설정해서 딱 맞게 가져가기
        // 제일 큰 나무높이부터 1씩 줄이기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] tmp = bf.readLine().split(" ");
        List<Integer> arr = new ArrayList<>();
        for(String i : tmp) {
            arr.add(Integer.parseInt(i));
        }
        Collections.sort(arr);

        int start = 0;
        int end = arr.get(n-1);
        int ans = 0;  // 답 저장
        while(start <= end) {
            // mid = 자르는 높이
            long tree = 0;  // 임시 나무 높이
            int mid = (start+end)/2;
            for(int i = 0; i < n; i++) { // 가져갈 나무 높이 구하기
                if(arr.get(i) > mid) {
                    tree += arr.get(i) - mid;
                }
            }
            if(tree < m) {  // m보다 가져갈 나무 길이가 작으면
                end = mid-1;

            } else if(tree > m) { // m이 너무 높으면 기준 줄이기
                start = mid+1;
            } else {
                System.out.println(mid);
                System.exit(0);
            }
        }
        System.out.println(end);
    }
}
