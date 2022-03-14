import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();
        while(k --> 0) {
            int num = Integer.parseInt(bf.readLine());
            if(num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int sum = 0;
        for(int i : stack) {
            sum += i;
        }
        System.out.println(sum);
    }
}
