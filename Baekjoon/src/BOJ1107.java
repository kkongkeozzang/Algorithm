import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];  // 부서진 버튼 확인 배열
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int btn = Integer.parseInt(st.nextToken());
                broken[btn] = true;  // 버튼이 부서졌다면 true로 바꿔준다
            }
        }

        // +,-를 누르면서 바꿨을 경우 초기값
        // 0으로 하게되면 0이 min이 나오는 경우가 생긴다.
        int count = Math.abs(N - 100);
        for(int i = 0; i <= 999999; i++) {  // i 최댓값은 9버튼만 살아있을 경우 : 999999
            String str = String.valueOf(i);
            int len = str.length();  // 버튼 누르는 횟수 체크 용도

            boolean isBroken = false;  // 초깃값 설정
            for(int j = 0; j < len; j++) {  // 버튼 누르는 횟수 동안 반복
                if(broken[str.charAt(j) - '0']) {  // chatAt(index) - '0' : 문자형 숫자를 int형으로
                    isBroken = true;  // 버튼이 부서졌다면 true
                    break;  // 더이상 탐색X
                }
            }
            if(!isBroken) {  // 버튼이 부서지지 않았다면
                int min = Math.abs(N - i) + len;  // N까지 이동하는 횟수(N-i) + i를 누르는 횟수(len)
                count = Math.min(min, count);  // 작은 값으로 갱신
            }
        }
        System.out.println(count);
    }
}
