import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        // 짝이 맞는 괄호라면 Yes 아니면 No
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(t --> 0) {
            Stack<String> stack = new Stack<>();
            char[] tmp = bf.readLine().toCharArray();
            String[] arr = new String[tmp.length];
            for(int i = 0; i < tmp.length; i++) {
                arr[i] = String.valueOf(tmp[i]);
            }
            for(String i : arr) {
                if(i.equals("(")) {
                    stack.push(i);
                } else {
                    if(stack.size()==0) { // 스택이 0인데 닫는 괄호가 있다면
                        //sb.append("NO").append("\n");
                        stack.push(i);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.size()==0) {  // for문이 끝났는데 size가 0이라면
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}
