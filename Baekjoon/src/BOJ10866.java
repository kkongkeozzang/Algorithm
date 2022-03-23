import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        Deque deque = new Deque(n);
        while(n --> 0) {
            String[] cmds = bf.readLine().split(" ");
            switch(cmds[0]) {
                case "push_front":
                    deque.pushFront(Integer.parseInt(cmds[1]));
                    break;
                case "push_back":
                    deque.pushBack(Integer.parseInt(cmds[1]));
                    break;
                case "pop_front":
                    sb.append(deque.popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(deque.popBack()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.empty()).append("\n");
                    break;
                case "front":
                    sb.append(deque.front()).append("\n");
                    break;
                case "back":
                    sb.append(deque.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

}
class Deque {
    private int[] deque;
    private int frontIndex = 0;
    private int backIndex = 1;
    private int size = 0;

    Deque() {}

    public Deque(int num) {
        deque = new int[num];
    }

    public void pushFront(int num) {
        deque[frontIndex--] = num;
        size++;

        if(frontIndex <= -1){
            frontIndex = deque.length -1;
        }
    }

    public void pushBack(int num) {
        deque[backIndex++] = num;
        size++;

        if(backIndex >= deque.length) {
            backIndex = 0;
        }
    }

    public int popFront(){
        if(size == 0) {
            return -1;
        }
        if(frontIndex >= deque.length-1) {
            frontIndex = 0;
        } else {
            frontIndex++;
        }
        size--;
        return deque[frontIndex];
    }

    public int popBack(){
        if(size == 0) {
            return -1;
        }
        if(backIndex <= 0) {
            backIndex = deque.length-1;
        } else {
            backIndex--;
        }
        size--;
        return deque[backIndex];
    }

    public int size() {
        return size;
    }

    public int empty() {
        return size == 0 ? 1 : 0;
    }

    public int front() {
        if(size == 0) { return -1; }
        if(frontIndex >= deque.length-1) {
            return deque[0];
        }
        return deque[frontIndex+1];
    }


    public int back() {
        if(size == 0) { return -1; }
        if(backIndex <= 0) {
            return deque[deque.length-1];
        }
        return deque[backIndex-1];
    }


}
