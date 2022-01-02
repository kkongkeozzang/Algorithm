import java.util.Scanner;

public class BOJ1152 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().strip().split(" ");
        if(str[0].equals("")){
            System.out.println(0);
        }else{
            System.out.println(str.length);
        }
    }
}
