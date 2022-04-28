import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> deque;
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t --> 0) {
            String cmd = br.readLine();  // p에 해당하는 명령어
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(),"[],");  // 숫자만 빼기

            deque = new ArrayDeque<>();

            // 덱 채우기
            for(int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            AC(cmd, deque);
        }

        System.out.println(sb);

    }
    public static void AC(String command, ArrayDeque<Integer> deque) {

        boolean isRight = true;  // 정방향으로 읽기

        for(char cmd : command.toCharArray()) {
            if(cmd == 'R') {
                isRight = !isRight;  // 리버스하기
                continue;
            }

            // 아래는 D일 경우

            if(isRight) {  // 정방향일 때
                if(deque.pollFirst() == null) {  // 꺼낼 것이 없다면
                    sb.append("error").append("\n");  // 에러 표시
                    return;
                }
            } else {  // 역방향일 때
                if(deque.pollLast() == null) {
                    sb.append("error").append("\n");
                    return;
                }
            }
        }

        // 남은 요소 출력하기
        makePrintString(deque, isRight);
    }

    public static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {

        sb.append("[");  // 처음 [ 추가

        if(deque.size() > 0) {
            if(isRight) {  // 정방향이라면
                sb.append(deque.pollFirst());  // 첫 번째 원소 넘기기

                while(!deque.isEmpty()) {  // 덱이 빌 때까지
                    sb.append(",").append(deque.pollFirst());  // 요소를 꺼내면서 ,추가
                }
            } else {  // 역방향이라면
                sb.append(deque.pollLast());

                while(!deque.isEmpty()) {
                    sb.append(",").append(deque.pollLast());
                }
            }
        }

        sb.append("]").append("\n");  // ] 추가하며 마무리리
    }
}
