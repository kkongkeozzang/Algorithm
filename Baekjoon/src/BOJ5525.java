import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] s = br.readLine().toCharArray();

        int result = 0;  // 정답
        int patternCnt = 0;  // 반복횟수(n과 비교하기 위한)

        for(int i = 1; i < m - 1; i++) {  // 문자열 돌리기
            if(s[i-1] == 'I' && s[i] == 'O' && s[i+1] == 'I') {  // IOI 패턴을 찾는다면
                patternCnt++;  // 패턴횟수 +1
                i++;  // i 한번 건너뛴다(I는 체크할 필요가 없으므로)
            } else {  // 패턴이 끊기면
                patternCnt = 0;  // 패턴횟수 초기화
            }

            if(patternCnt >= n) {  // 패턴횟수가 n과 같거나 크다면
                result++;  // 정답 +1
            }
        }

        System.out.println(result);
    }
}
