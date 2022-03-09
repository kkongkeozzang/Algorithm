import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        // 마지막에 0 0 0 입력 -> 끝
        // 직각 삼각형이 맞으면 "right" 아니면 "wrong"
        // a^2 + b^2 = c^2
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] tmp = bf.readLine().split(" ");
            List<Integer> arr = new ArrayList<>();
            for(String i : tmp) {
                arr.add(Integer.parseInt(i));
            }
            if(arr.get(0)==0 && arr.get(1)==0 && arr.get(2)==0) {
                break;
                //System.exit(0);
            }
            // 가장 큰 수 구하기
            int max = 0;
            for(int i : arr) {
                max = Math.max(i, max);
            }
            arr.remove(arr.indexOf(max));
            // 작은 두 수와 가장 큰 수가 피타고라스 정리에 맞는지 확인
            if(Math.pow(arr.get(0),2)+Math.pow(arr.get(1),2)==Math.pow(max,2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

    }
}
