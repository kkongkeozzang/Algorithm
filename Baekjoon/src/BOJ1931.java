import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] time = new int[n][2];
        StringTokenizer st;

        // 시간 배열에 넣기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        // 정렬 재정의
        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) {  // 종료 순서가 같을 경우
                return o1[0] - o2[0];  // 시작 순서가 빠른 순서로 정렬
            }

            return o1[1] - o2[1];  // 종료 순서가 빠른 순서로 정렬
        });

        int count = 0;  // 회의 최대 갯수
        int prevEndTime = 0;  // 이전 끝나는 시간

        for(int i = 0; i < n; i++) {
            if(prevEndTime <= time[i][0]) {  // 끝나는 시간보다 시작 시간이 크거나 같다면
                prevEndTime = time[i][1];  // 끝나는 시간 갱신
                count++;  // 카운트 +1
            }
        }

        System.out.println(count);
    }
}
