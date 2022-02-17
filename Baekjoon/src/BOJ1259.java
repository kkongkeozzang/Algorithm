import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String word = bf.readLine();
            if(!word.equals("0")) {
                // String으로 받아서 toCharArray로 배열로 바꾼다
                // reverse 하여 /2로 나눈 뒤 일치하는지 확인
                char[] target = word.toCharArray();
                String[] targetW = new String[target.length];
                for(char i = 0; i < target.length; i++) {
                    targetW[i] = String.valueOf(target[i]);
                }
                String[] targetR = targetW.clone();
                List<String> targetRarr = Arrays.asList(targetR);
                Collections.reverse(targetRarr);
                boolean isPalNum = true;
                for(int i = 0; i < targetW.length/2; i++) {
                    if(!targetW[i].equals(targetR[i])) {
                        isPalNum = false;
                        break;
                    }
                }
                if(isPalNum) {
                    bw.write("yes\n");
                } else {
                    bw.write("no\n");
                }
                bw.flush();
            } else {
                System.exit(0);
                bw.close();
            }
        }
    }
}
