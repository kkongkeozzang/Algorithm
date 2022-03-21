import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10828 {
    public static List<Integer> stack = new ArrayList<>();
    public static void push(int num) {
        stack.add(num);
    }
    public static int pop() {
        if(stack.size()==0) {
            return -1;
        }
        int tmp = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return tmp;
    }
    public static int size() {
        return stack.size();
    }
    public static int empty() {
        if(stack.size()==0) {
            return 1;
        }
        return 0;
    }
    public static int top() {
        if(stack.size()==0) {
            return -1;
        }
        return stack.get(stack.size()-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0) {
            String[] arr = bf.readLine().split(" ");
            if(arr.length==2) {
                push(Integer.parseInt(arr[1]));
            } else {
                if(arr[0].equals("top")) {
                    sb.append(top()).append("\n");
                } else if(arr[0].equals("size")) {
                    sb.append(size()).append("\n");
                } else if(arr[0].equals("pop")) {
                    sb.append(pop()).append("\n");
                } else if(arr[0].equals("empty")) {
                    sb.append(empty()).append("\n");
                }
            }

        }
        System.out.println(sb);

    }
}
