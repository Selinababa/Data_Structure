package Chapter03_01;
import java.util.Scanner;
import Chapter03_01.SqStack;

public class AC3_2_2Palindrome { //�ж�һ���ַ������Ƿ�Ϊ�������У�ֻ��ջ��ʵ��
	
	public boolean Palindrome(String s) throws Exception {
		LinkStack S = new LinkStack();
		int i = 0;
		for(; i<s.length(); i++) {
			S.push(s.charAt(i));//���ַ���תΪ�����ַ�����ջ����ջ��Ԫ�س�ջ˳��Ϊ�ַ���������
		}
		for(i = 0; i<s.length(); i++) {
			char c = ((Character)S.pop()).charValue(); //cΪջ��Ԫ�أ���ԭ�ַ��������һ���ַ�
			if(c != s.charAt(i))//��ջ��Ԫ�����ַ������ַ����αȽϣ�����һ������ȣ�
				return false; //�򷵻�flase�������ַ������ǻ�������
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
