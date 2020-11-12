package Chapter03_01;
import java.util.Arrays;
import java.util.Scanner;

public class AC3_1_2Reverse {
	private static int maxSize = 9;
	public String reverse02(String s) throws Exception {
		LinkStack LS = new LinkStack();
		//将字符串转化为字符数组
		char [] a = s.toCharArray();
		//将字符数组存入栈中
		for(int i=0; i<maxSize; i++) {
			LS.push(a[i]);
		}
		//将栈中元素按顺序存入数组b
		for(int i=0; i<maxSize; i++) {
			a[i] = (char) LS.pop();
		}
		//将新数组转化为字符串？
		String x = Arrays.toString(a);
		return x;
		
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		AC3_1_2Reverse ac = new AC3_1_2Reverse();
		
		System.out.println("Please input a array consisting of " + maxSize + " characters:");
		String s = sc.next();
		System.out.println(ac.reverse02(s));
	}
}
