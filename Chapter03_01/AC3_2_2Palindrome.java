package Chapter03_01;
import java.util.Scanner;
import Chapter03_01.SqStack;

public class AC3_2_2Palindrome { //判断一个字符序列是否为回文序列，只用栈来实现
	
	public boolean Palindrome(String s) throws Exception {
		LinkStack S = new LinkStack();
		int i = 0;
		for(; i<s.length(); i++) {
			S.push(s.charAt(i));//将字符串转为单个字符并入栈，则栈内元素出栈顺序为字符串的逆序
		}
		for(i = 0; i<s.length(); i++) {
			char c = ((Character)S.pop()).charValue(); //c为栈顶元素，即原字符串的最后一个字符
			if(c != s.charAt(i))//将栈中元素与字符串中字符依次比较，若有一个不相等，
				return false; //则返回flase，即该字符串不是回文序列
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		AC3_2_2Palindrome ac1 = new AC3_2_2Palindrome();
		System.out.println("Please input a string needs judging:");
		String s = sc.next();
		if(ac1.Palindrome(s))
			System.out.println("This is a Palindrome!");
		else 
			System.out.println("This isn't a Palindrome!");
	}
}
