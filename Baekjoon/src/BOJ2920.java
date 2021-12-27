import java.util.Scanner;

public class BOJ2920 {
	public static void main(String[] args) {
		
		String[] arr = {"1","2","3","4","5","6","7","8"};
		String[] reverseArr = {"8","7","6","5","4","3","2","1"};
		
		Scanner sc = new Scanner(System.in);
		String[] ans = sc.nextLine().split(" ");
		sc.close();
		int a = 0;
		int r = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(ans[i].equals(arr[i])) {
				a += 1;
			}else if(ans[i].equals(reverseArr[i])) {
				r += 1;
			}
		}
		
		if(a==8) {
			System.out.println("ascending");
		}else if(r==8) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}
	}
}
