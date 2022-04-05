import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

// DFS : 재귀, BFS : Queue
// 노드 수가 적으면 인접행렬, 많으면 인접리스트 사용

// 인접행렬 사용
public class BOJ1260 {
    static boolean[] check;  // 체크배열
    static int[][] A;  // 인접행렬
    static int N;  // 정점 갯수
    static int M;  // 간선 갯수
    static int V;  // 시작 정점 번호

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];  // 0을 사용안하기 때문
        A = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x][y] = 1;  // 간선이 존재하는 경우 1
            A[y][x] = 1;  // 양뱡향
        }
        // 자식이 여러개라면 노드 번호가 작은것 부터 방문 -> 오름차순 정렬
        dfs(V);
        // Arrays.fill : check 배열에 false를 일괄적으로 채운다.
        Arrays.fill(check,false);  // check 배열 초기화
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
    static void dfs(int x) {
        check[x] = true;  // 방문 후 체크
        sb.append(x).append(" ");

        for(int i = 1; i <= N; i++) {  // 정점의 갯수만큼 탐색
            // 인접한 노드가 방문한 적이 없고, 연결되어있다면 dfs 수행
            if(!check[i] && A[x][i] == 1) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;  // 방문하고
        q.offer(v);  // queue에 정점 추가

        while(!q.isEmpty()) {  // queue가 비어있을 때까지 반복
            int x = q.poll();  // queue의 첫번째 값을 반환하고 제거 비어있다면 null
            sb.append(x).append(" ");
            for(int i = 1; i <= N; i++) {  // 정점의 갯수만큼 탐색
                // 인접한 노드가 방문한 적이 없고, 연결되어있다면
                if(!check[i] && A[x][i] == 1) {
                    check[i] = true;  // 방문하고
                    q.offer(i);  // queue에 정점 추가
                }
            }
        }
    }
}

// 인접리스트 사용
class BOJ1260_2 {
    static boolean[] check;
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>();
    static int N;
    static int M;
    static int V;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        check = new boolean[N+1];

        for(int i = 0; i <= N; i++) {  // 0부터 정점 갯수까지 (0은 사용안하니까)
            A.add(new ArrayList<Integer>());  // 초기화
        }

        for(int i = 0; i < M; i++) {  // 정점 좌표 넣기
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A.get(x).add(y);
            A.get(y).add(x);
        }
        // 자식이 여러개라면 노드 번호가 작은 것부터 방문 : 오름차순 정렬
        for(int i = 0; i <= N; i++) {
            Collections.sort(A.get(i));
        }
        dfs(V);
        check = new boolean[N+1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }
    static void dfs(int x) {
        check[x] = true;
        sb.append(x).append(" ");

        for(int i = 0; i < A.get(x).size(); i++) {
            int y = A.get(x).get(i);
            if(!check[y]) {
                dfs(y);
            }
        }
    }
    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        check[v] = true;
        q.offer(v);

        while(!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            for(int i = 0; i < A.get(x).size(); i++){
                int y = A.get(x).get(i);
                if(!check[y]) {
                    check[y] = true;
                    q.offer(y);
                }
            }
        }
    }
}
