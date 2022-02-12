import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ10871 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = sc.nextInt();
        sc.nextLine();
        String[] arr = sc.nextLine().split(" ");
        List<String> ansArr = new ArrayList<>();
        for(String i : arr) {
            if(ans > Integer.parseInt(i)) {
                ansArr.add(String.valueOf(Integer.parseInt(i)));
            }
        }
        System.out.println(String.join(" ", ansArr));
    }
}
