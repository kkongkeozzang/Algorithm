import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i <  t; i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < n; j++) {
                q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
            }
            int count = 0; // 출력 횟수

            while(!q.isEmpty()) {  // 한 케이스에 대한 반복문

                int[] front = q.poll(); // 가장 첫 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지
                // 지금꺼보다 중요도가 높은게 있는지 확인
                for(int j = 0; j < q.size(); j++) {
                    if(front[1] < q.get(j)[1]) { // 더 높은게 있다면
                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다
                        q.offer(front);
                        for(int k = 0; k < j; k++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(!isMax) { // 중요도가 제일 높지 않으면 pass
                    continue;
                }

                count++;  // front가 가장 큰 원소이므로 출력 카운트 +1
                if(front[0] == m) {  // 찾는 순서라면 종료
                    break;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
