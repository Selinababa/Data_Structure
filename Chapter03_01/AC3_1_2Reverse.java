package Chapter03_01;
import java.util.Arrays;
import java.util.Scanner;

public class AC3_1_2Reverse {
	private static int maxSize = 9;
	public String reverse02(String s) throws Exception {
		LinkStack LS = new LinkStack();
		//���ַ���ת��Ϊ�ַ�����
		char [] a = s.toCharArray();
		//���ַ��������ջ��
		for(int i=0; i<maxSize; i++) {
			LS.push(a[i]);
		}
		//��ջ��Ԫ�ذ�˳���������b
		for(int i=0; i<maxSize; i++) {
			a[i] = (char) LS.pop();
		}
		//��������ת��Ϊ�ַ�����
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
