import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // n = 1인 경우 인덱스 넘어가는 오류 발생시키지 않기 위해 n+2를 해준다.
        int[] stair = new int[n+2];

        // stair에 값 넣어주기
        for(int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }
        // 누적합 계산할 score 배열 생성
        int[] score = new int[n+2];
        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        for(int i = 3; i <= n; i++) {
            // n-3번째 + n-1번째, n-2번째 중 큰 수와 기존 n번째 계단 점수를 더해준다.
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }

        System.out.println(score[n]);

    }
}
