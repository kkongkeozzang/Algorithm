import java.util.Scanner;

public class BOJ8958 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i=0;i<t;i++) {
			int count = 0;
			int num = 1;
			String str = sc.nextLine();
			char[] arr = str.toCharArray();
			for(int j=0;j<arr.length;j++) {
				if(Character.toString(arr[j]).equals("O")) {
					count += num;
					num += 1;
				}else {
					num = 1;
				}
				
			}
			System.out.println(count);
		}
	}
}
