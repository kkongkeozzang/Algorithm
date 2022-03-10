import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        // 문자열이 균형이면 yes, 아니면 no 출력
        // 맨 마지막에 점 하나 -> 종료
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String target = bf.readLine();  // 문자열 돌려주기
            if(target.equals(".")) {  // 종료조건
                break;
            }
            // 문자열 쪼개기
            char[] tmp = target.toCharArray();
            // String 배열로 만들기
            String[] arr = new String[tmp.length];
            for(int i = 0; i < tmp.length; i++) {
                arr[i] = String.valueOf(tmp[i]);
            }
            // 문자열 넣을 스택 생성
            Stack<String> stack = new Stack<>();
            // 균형을 이루는지 체크
            // for문을 돌리면서 괄호는 stack에 넣어주고 짝이 맞으면 stack에서 지운다
            // stack이 비어있으면 균형이 맞는 것
            for(String i : arr) {
                if("[".equals(i)) {
                    stack.push(i);
                } else if("(".equals(i)) {
                    stack.push(i);
                } else if ("]".equals(i)) {
                    if(stack.size()==0) {
                        stack.push(i);
                    }
                    if(stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else if (")".equals(i)) {
                    if(stack.size()==0) {
                        stack.push(i);
                    }
                    if(stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }

            }
            if(stack.size()==0) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

        }
        System.out.println(sb);
    }
}
