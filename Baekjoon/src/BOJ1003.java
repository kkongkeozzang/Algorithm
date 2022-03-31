import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ1003 {
    public static Map<Integer,int[]> map = new HashMap<>();
    public static int[] fibo(int num) {
        map.put(0,new int[] {1,0});
        map.put(1,new int[] {0,1});
        map.put(2,new int[] {1,1});

        if(map.get(num)==null) {
            int[] tmp = new int[2];
            tmp[0] = fibo(num-1)[0] + fibo(num-2)[0];
            tmp[1] = fibo(num-1)[1] + fibo(num-2)[1];

            map.put(num,tmp);
            return tmp;
        }
        return map.get(num);
    }
    public static void main(String[] args) throws IOException {
        // 4 = f(3),f(2)
        // 3 = f(2),f(1)
        // 3 = {1,1} + {0,1} = {1,2}
        // 2 = f(1),f(0) = {1,1}

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t --> 0) {
            int target = Integer.parseInt(br.readLine());
            sb.append(fibo(target)[0]).append(" ").append(fibo(target)[1]).append("\n");
        }
        System.out.println(sb);
    }
}
