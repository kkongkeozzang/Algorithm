import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        // -1, -2, -3, -1, -2
        // 산술평균 : 전부 더해서 n으로 나누기, 정수로 나타냄
        // 중앙값 : sort해서 length/2하고 값 출력
        // 최빈값 : 카운팅 sort
        // 범위 : 최댓값 - 최솟값

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        sb.append((int)(Math.round(sum/(double)n))).append("\n");
        int[] arrC = arr.clone();
        Arrays.sort(arrC);
        sb.append(arrC[n/2]).append("\n");

        int max = Integer.MIN_VALUE;
        int[] arrP = new int[8001];
        List<Integer> maxArr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arrP[arr[i]+4000]++;
        }
        for(int i = 0; i <= 8000; i++) {
            if(max < arrP[i]) {
                max = arrP[i];
            }
        }
        for(int i = 0; i <= 8000; i++) {
            if(max == arrP[i]) {
                maxArr.add(i-4000);
            }
        }
        if(maxArr.size() == 1) {
            sb.append(maxArr.get(0)).append("\n");
        } else {
            Collections.sort(maxArr);
            sb.append(maxArr.get(1)).append("\n");
        }
        sb.append(arrC[n-1]-arrC[0]);
        System.out.println(sb);

    }
}
