import java.util.Scanner;

public class BOJ1018 {
    public static void main(String[] args) {

        char[][] answerW = {
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}
        };

        char[][] answerB = {
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}
        };

        int countW = 0;
        int countB = 0;

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] compare = new char[m][n];
        for(int i = 0; i < m; i++) {
            compare[i] = sc.nextLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m-7; i++) {
            for(int j = 0; j < n-7; j++) {
                for(int k = 0; k < 8; k++) {
                    for(int l = 0; l < 8; l++) {
                        if(answerW[k][l] != compare[k+i][l+j]) {
                            countW++;
                        } else if (answerB[k][l] != compare[k+i][l+j]) {
                            countB++;
                        }

                    }
                }
                min = Integer.min(min,Integer.min(countW, countB));
                countW = 0;
                countB = 0;
            }
        }
        System.out.println(min);
    }
}
