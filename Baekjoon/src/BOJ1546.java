import java.util.Scanner;

public class BOJ1546 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        double maxNum = 0;
        for(double i : arr) {
            if(maxNum<i) {
                maxNum = i;
            }
        }
        double total = 0;
        for(int i=0;i<n;i++) {
            arr[i] = (arr[i]/maxNum)*100;
            total += arr[i];
        }
        System.out.println(total/arr.length);
    }
}
