import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ1874 {
    public static void main(String[] args) throws IOException {
        //43687521
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        // arr에 입력된 수열 넣기
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        // 답안 ans 리스트 생성
        List<String> ans = new ArrayList<>();
        // 스택 배열 생성
        Stack<Integer> stack = new Stack<>();
        // 기준 start 변수 생성
        int start = 1;
        // 수열값보다 작다면 수열값까지 push(+)하다 수열값이 되면 pop(-)하기
        for(int i = 0; i < n; i ++) {
            if(arr[i] >= start) { // 수열보다 num이 작을 경우 +를 해준다.
                for(int j = start; j <= arr[i]; j++) {
                    stack.push(start); // 스택에 값 넣기
                    start++; // start 1 올려주고
                    ans.add("+"); // 답지에 + 적어주기
                }
            }
            if(stack.peek() != arr[i]) { // 스택의 가장 위 값이 수열 값과 같지 않으면 NO
                bw.write("NO");
                bw.flush();
                bw.close();
                System.exit(0);
            }
            for(int k = 0; k < stack.size(); k++) {
                if(arr[i] <= stack.peek()) { // 같을때까지 pop
                    ans.add("-");
                    stack.pop();
                } else {
                    break;
                }
            }
        }
        for(String i : ans) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
