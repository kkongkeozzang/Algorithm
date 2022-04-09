import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 조건 : 뺄셈을 기준으로 수를 다 더해주고 큰 수를 빼야 최솟값이 나온다.
        // 주의할 것 : 맨 처음 값은 + 해주기

        int sum = Integer.MAX_VALUE;  // 첫번째 수를 더하기 위한 초기화 조건
        // -를 기준으로 문자열 나누기
        String[] minusSplitArr = br.readLine().split("-");
        // 나눈 문자열 안에서
        for (String s : minusSplitArr) {
            int tmp = 0;  // 덧셈 넣을 임시 공간
            // split은 정규식을 받기 때문에 + 그대로 쓸 수 없다.
            // +를 기준으로 또한번 나눠주기
            String[] addSplitArr = s.split("\\+");
            // +로 나눈 문자열을 다 더해준다
            for (String i : addSplitArr) {
                tmp += Integer.parseInt(i);
            }
            // sum 변수가 초기화 값과 같다면 아직 시작 X 이므로 첫 번째 수 담아주기
            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {  // 아니라면 시작했으므로 계속 빼주기
                sum -= tmp;
            }
        }
        System.out.println(sum);


    }
}
