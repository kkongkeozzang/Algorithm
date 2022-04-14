import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {

    static int n;  // 수빈이의 위치
    static int k;  // 동생의 위치

    static int[] visited = new int[100001];  // 거리 배열 생성

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.close();

        int result = bfs(n);
        System.out.println(result);
    }

    static int bfs(int x) {
        Queue<Integer> q = new LinkedList<>();  // bfs는 queue 사용

        q.add(x);  // 처음으로 수빈이의 위치 queue에 넣기
        visited[x] = 1;  // 처음을 1초로 놓고, 출력할 때 -1 해줌
        int s; // 수빈이의 위치
        while(q.size() != 0) {
            s = q.remove();  // queue에서 제거

            if(s == k) {  // 위치가 같다면
                return visited[s]-1;  // -1 해서 출력
            }
            if(s-1>=0 && visited[s-1] == 0) {  // 범위안에 있고 방문하지 않았을 때
                visited[s-1] = visited[s]+1;  // 방문한 곳에 현재 시간+1 넣기
                q.add(s-1);  // queue에 넣기
            }
            if(s+1<=100000 && visited[s+1] == 0) {
                visited[s+1] = visited[s]+1;
                q.add(s+1);
            }
            if(s*2<=100000 && visited[s*2] == 0) {
                visited[s*2] = visited[s]+1;
                q.add(s*2);
            }
        }
        return -1;
    }
}
