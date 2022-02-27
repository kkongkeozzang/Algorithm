import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {
    public static void main(String[] args) throws IOException {
        //216 198+1+9+8
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;  // 정답 출력할 변수
        for(int i = 0; i < n; i++) {  // 0부터 n까지 1씩 증가하면서 찾기
            int ans = i;  //  n을 직접 건드리지 않기 위해
            int sum = 0;  //  자릿수 합하기
            while(ans != 0) {  // 자릿수 나누기
                sum += ans % 10;
                ans = ans/10;
            }
            if(sum + i == n) {  // 찾으면
                result = i;  // 답을 갱신
                break;
            }
        }
        System.out.println(result);  //  못찾는 경우 0 출력

    }
}
