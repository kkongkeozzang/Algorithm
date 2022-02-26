import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        // 1부터 n까지 번호
        // 맨 위 카드 없애기 그 다음 카드 제일 밑으로 보내기 반복
        // 1장이 남을 때 까지
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        // 1부터 n까지 큐에 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while(queue.size() != 1) {
            // 맨 왼쪽 버리기
            queue.remove();
            // 맨 왼쪽 꺼를 오른쪽으로 옮기기
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
