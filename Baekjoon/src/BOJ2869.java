import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        // 높이 v미터
        // 낮에 +a미터 밤에 -b미터
        // 정상에 올라간 후에는 - 없음
        // a, b, v 주어진다
        // v를 올라가는데 모두 며칠?
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        // 낮 / (밤 + 낮) / (밤 + 낮) / ...
        int m = v-a;
        // v-a(하루) / (-밤+낮)(하루) = 올라간 day(올림)
        System.out.println((int)(Math.ceil(m/(double)(a-b)))+1);


    }
}
