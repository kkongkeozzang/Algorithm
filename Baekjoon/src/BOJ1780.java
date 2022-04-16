import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {
    static int[][] board;
    static int gray = 0;  // -1
    static int white = 0;  // 0
    static int black = 0;  // 1

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        StringTokenizer st;

        // 보드 채우기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0,0,n);

        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);
    }

    static void partition(int row, int col, int size) {

        // 같은 색이면 카운트 증가
        if(colorCheck(row,col,size)) {
            if(board[row][col] == -1) {
                gray++;
            }else if(board[row][col] == 0) {
                white++;
            }else {
                black++;
            }
            return;
        }

        // 영역 3분할로 쪼개기
        int newSize = size / 3;

        // 9개의 영역으로 나눠서 다시 실행
        partition(row,col,newSize);
        partition(row,col+newSize,newSize);
        partition(row,col+2*newSize,newSize);

        partition(row + newSize,col,newSize);
        partition(row + newSize,col+newSize,newSize);
        partition(row + newSize,col+2*newSize,newSize);

        partition(row + 2*newSize,col,newSize);
        partition(row + 2*newSize,col+newSize,newSize);
        partition(row + 2*newSize,col+2*newSize,newSize);
    }

    static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col];  // 비교할 색상

        // 시작부터 끝까지 검사하다 색이 다르면 종료
        for(int i = row; i < row+size; i++) {
            for(int j = col; j < col+size; j++) {
                if(color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
