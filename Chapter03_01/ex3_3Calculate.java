package Chapter03_01;
import java.util.*;
public class ex3_3Calculate {
	
	//���������ʽת��Ϊ��׺���ʽ�ĺ�����������ַ�������ʽ����
	public String convertToPostfix(String expression) throws Exception{
		LinkStack st = new LinkStack();//��ʼ��һ�������ջ
		String postfix = new String();//���ڴ�������ĺ�׺���ʽ
		
		for(int i = 0; expression != null && i<expression.length(); i++) {
			char c = expression.charAt(i);//���������ʽ�ж�ȡһ���ַ�
			if(' ' != c) {		//�ַ�c��Ϊ�ո�
				if(isOpenParenthesis(c)) {
					st.push(c);  //Ϊ�����ţ�ѹջ
				}
				else if(isCloseParenthesis(c)) { //Ϊ������
					char ac = (Character) st.pop(); //����ջ��Ԫ��
					while(!isOpenParenthesis(ac)) { //һֱ��Ϊ������Ϊֹ
						postfix = postfix.concat(String.valueOf(ac));
						//��������׺���ʽ�Ľ�β
						ac = (Character) st.pop();
					}
				}
				else if(isOperator(c)) {//Ϊ�����
					if(!st.isEmpty()) {//ջ�ǿգ�ȡ��ջ�����ȼ��ߵ������������׺���ʽ
						Object ac = (Object) st.pop();
						while(ac != null && priority(((Character) ac).charValue()) >= priority(c)) {
							postfix = postfix.concat(String.valueOf(ac));
							ac = (Character) st.pop();
						}
						if(ac != null) {//�����һ��ȡ�������ȼ��͵Ĳ�����������ѹջ
							st.push(ac);
						}
					}
					st.push(c);//ѹջ
				}
				else { //Ϊ����������������׺���ʽ�Ľ�β
					postfix = postfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()) //ջ��ʣ������в�������������׺���ʽ�Ľ�β
			postfix = postfix.concat(String.valueOf(st.pop()));
		return postfix;
	}
	
	//�Ժ�׺���ʽ������ֵ����ĺ���
	public double numberCalculate(String postfix) throws Exception{
		LinkStack st = new LinkStack();
		for(int i = 0; postfix !=null && i<postfix.length(); i++) {
			char c = postfix.charAt(i);//�Ӻ�׺���ʽ�ж�ȡһ���ַ�
			if(isOperator(c)) {//��Ϊ������ʱ
				//ȡ������������
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if('+' == c) {//�ӷ�����
					d3 = d1 + d2;
				}else if('-' == c) { //��������
					d3 = d1 - d2;
				}else if('*' == c) { //�˷�����
					d3 = d1 * d2;
				}else if('/' == c) { //��������
					d3 = d1 / d2;
				}else if('^' == c) {//������
					d3 = Math.pow(d1, d2);
				}else if('%' == c) { //��������
					d3 = d1 % d2;
				}
				st.push(d3);//��Ϊ������
			}else {
				st.push(c);
			}
		}
		return(Double)st.pop();//����������
	}
	
	//�ж��ַ����Ƿ�Ϊ�����
	public boolean isOperator(char c) {
		if('+' == c || '-' == c || '*' == c || '/' == c || '^' == c || '%' == c) {
			return true;
		}else {
			return false;
		}
	}
	
	//�ж��ַ����Ƿ�Ϊ������
	public boolean isOpenParenthesis(char c) {
		return '(' ==c;
	}
	
	//�ж��ַ����Ƿ�Ϊ������
	public boolean isCloseParenthesis(char c) {
		return ')' == c;
	}
	
	//�ж����㷨�����ȼ�
	public int priority(char c) {
		if(c == '^') { //Ϊ�������
			return 3;
		}
		if(c == '*' || c == '/' || c == '%') {//Ϊ�˷���������ȡģ����
			return 2;
		}
		else if(c == '+' || c == '-') { //Ϊ�ӣ�������
			return 1;
		}else {   //����
			return 0;
		}	
	}
	
	public static void main(String[] args) throws Exception{
		ex3_3Calculate p = new ex3_3Calculate();
		String postfix = p.convertToPostfix("(1+2) * (5-2) / 2 ^ 2 + 5%3");//תΪ��׺���ʽ
		System.out.println("���ʽ���Ϊ��"+p.numberCalculate(postfix));//�Ժ�׺���ʽ��ֵ�����
	}
	
}
