package Chapter03_01;
import java.util.Scanner;
public class Example3_1 {
	private final int LEFT = 0; //��¼����Ϊ���󡱵ķָ���
	private final int RIGHT = 1; //��¼����Ϊ���ҡ��ķָ���
	private final int OTHER = 2; //��¼�����ַ�
	
	//�жϷָ��������ͣ���3�֣����󡱣����ҡ������Ƿ���
	public int verifyFlag(String str) {
		if("(".equals(str)||"{".equals(str)||"[".equals(str)||"/*".equals(str))
			return LEFT;
		else if(")".equals(str)||"}".equals(str)||"]".equals(str)||"*/".equals(str))
			return RIGHT;
		else
			return OTHER;
	}
	//������ָ���str1���ҷָ����Ƿ�ƥ��
	public boolean matches(String str1, String str2) {
		if(("(".equals(str1)&&")".equals(str2))||("{".equals(str1)&&"}".equals(str2))||("[".equals(str1)&&"]".equals(str2))||("/*".equals(str1)&&"*/".equals(str2)))
			return true;
		else
			return false;
	}
	//�ж����������Ƿ�Ϸ�
	private boolean isLegal(String str) throws Exception{
		if(!"".equals(str) && str != null) {
			SqStack S = new SqStack(100); //�½����洢�ռ�Ϊ100��˳��ջ
			int length = str.length();
			for(int i=0; i<length; i++) {
				char c = str.charAt(i);//ָ����������charֵ
				String t = String.valueOf(c); //ת�����ַ�����
				if(i != length) {
					if(('/' == c && '*' == str.charAt(i+1)) || ('*' == c && '/' == str.charAt(i+1))) {//�ָ�������Ϊ/*��*/
						t= t.concat(String.valueOf(str.charAt(i+1)));//���һ���ַ�����
						++i;
					}
				}
				if(LEFT == verifyFlag(t)) {
					S.push(t);//��tѹ��ջ
				}
				else if(RIGHT == verifyFlag(t)) {
					if(S.isEmpty() || !matches(S.pop().toString(),t)) {
						throw new Exception("����Java��䲻�Ϸ���");
					}
				}
			}
			if(!S.isEmpty())
				throw new Exception("����Java��䲻�Ϸ���");
			return true;
		}
		else
			throw new Exception("����Java���Ϊ�գ�");
	}
	//������
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Example3_1 e = new Example3_1();
		System.out.println("�������Java���");
		if(e.isLegal(sc.nextLine()))
			System.out.println("Java���Ϸ���");
		else
			System.out.println("����Java��䲻�Ϸ���");
	}
}
