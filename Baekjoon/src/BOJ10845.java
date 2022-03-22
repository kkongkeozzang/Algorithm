import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Queue queue = new Queue(n);
        StringBuilder sb = new StringBuilder();
        while(n --> 0) {
            String[] cmds = bf.readLine().split(" ");
            if(cmds.length == 2) {
                queue.push(Integer.parseInt(cmds[1]));
            }
            switch(cmds[0]) {
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        sb.append(1).append("\n");
                        break;
                    }
                    sb.append(0).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Queue {
    private int[] queue;
    private int frontIndex = 0;
    private int backIndex = 0;

    Queue() {}

    Queue(int num) {
        queue = new int[num];
    }
    public void push(int num) {
        queue[backIndex++] = num;
    }
    public int size() {
        return backIndex - frontIndex;
    }
    public boolean isEmpty() {
        if(size()==0) {
            return true;
        } else {
            return false;
        }
    }
    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        return queue[frontIndex++];
    }
    public int front() {
        if(isEmpty()) {
            return -1;
        }
        return queue[frontIndex];
    }

    public int back() {
        if(isEmpty()){
            return -1;
        }
        return queue[backIndex-1];
    }
}
