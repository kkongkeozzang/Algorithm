import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        long sum = 0;
        char[] arr = br.readLine().toCharArray();
        double r = Math.pow(31, 0);
        for(int i = 0; i < l; i++) {
            sum += (arr[i]-96)*r;
            r = r*31%1234567891;
        }
        System.out.println(sum%1234567891);

    }
}
