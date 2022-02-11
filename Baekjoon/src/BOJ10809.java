import java.util.Scanner;

public class BOJ10809 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = new String[26];
        String input = sc.nextLine();
        sc.close();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "-1";
        }
        char[] inputCharArr = input.toCharArray();
        for(char i : inputCharArr) {
            int index = input.indexOf(i);
            // 97 = 0 (int)a-97
            arr[(int)i-97] = index + "";
        }
        System.out.println(String.join(" ", arr));
    }
}
