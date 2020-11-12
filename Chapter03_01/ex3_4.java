package Chapter03_01;
import java.util.*;
public class ex3_4 {//�ж�������������ʽ�Ƿ���ȷ����������ֵ�����
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ex3_3Calculate cal = new ex3_3Calculate();
		
		System.out.println("�������������ʽ��"); //��ʾ����
		String n = sc.next(); //�������ʽΪһ���ַ���
		
		isComplete(n); //���ú����ж������Ƿ����

		//ѭ�����жϱ��ʽ�Ƿ�������ɣ���������������ʾ���룺
		while(!isComplete(n)) {
			System.out.println("��������δ��ɣ�����δƥ������ţ���������룺");
			n = n + sc.next();//����һ�������n��ڶ��������n��������
			
		}//ѭ����������Ϊ ��������ɣ����������Ŷ����ƥ��
		
		String n2 = cal.convertToPostfix(n);//���ú������������ʽת��Ϊ��׺���ʽ��������׺���ʽ����n2
		System.out.println(n2);//�����׺���ʽn2
		
		System.out.println(cal.numberCalculate(n2));//���ú��������׺���ʽ����������
	}
	
	//�����ж������Ƿ���ɵĺ��������ж����������Ƿ�ƥ��
	public static boolean isComplete(String n) {
		ex3_3Calculate cal = new ex3_3Calculate();
		LinkStack st = new LinkStack();//��ʼ��һ�������ջ
		String postfix = new String();//���ڴ�������ĺ�׺���ʽ
		int countL=0;//�������ͱ������ڼ����������ŵĸ���
		int countR=0;

		for(int i = 0; n != null && i<n.length(); i++) {
			char c = n.charAt(i); //���������ʽ�ж�ȡһ���ַ�
			if(' ' != c) {		//�ַ�c��Ϊ�ո�
				if(cal.isOpenParenthesis(c)) {
					//st.push(c);  //Ϊ�����ţ�ѹջ
					countL++;//��������1
				}
				else if(cal.isCloseParenthesis(c)) { //Ϊ������
					countR++;//��������1
				}
			}
		}
		if(countL == countR) 
			return true;
		else
			return false;
	}
}
