import java.util.Scanner;

public class BOJ1676 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        System.out.println(countZero(n));
    }

    static int countZero(int num) {
        int two = 0;
        int five = 0;
        for(int i = 1; i <= num; i++) {  // 팩토리얼처럼 반복해줌
            int n = i;

            while(n%2 == 0) {  // 2로 나눠 떨어지면 +1
                two++;
                n /= 2;  // 2로 나눠줌
            }

            while(n%5 == 0) {  // 5로 나눠 떨어지면 +1
                five++;
                n /= 5;  // 5로 나눠줌
            }
        }
        return Math.min(five, two);  // 둘 중 작은 것으로 리턴
    }

}
