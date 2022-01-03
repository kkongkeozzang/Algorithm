import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        char[] str = sc.nextLine().toUpperCase().toCharArray();

        for(char c : str) {
            map.put(c, map.getOrDefault(c,0) +1);
            if(max < map.get(c)){
                max = map.get(c);
            }
        }
        int count = 0;
        char ch = '?';
        for(Map.Entry<Character,Integer> tmp : map.entrySet()) {
            if(tmp.getValue().equals(max)) {
                count ++;
                ch = tmp.getKey();
            }
        }
        if(count > 1) {
            System.out.println("?");
        } else {
            System.out.println(ch);
        }
    }
}
