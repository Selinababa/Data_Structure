package Chapter03_01;

public class Example3_2 {
	//�����������ĺͣ������ͱ��������ַ�������ʽ���루��������г��ֿո񣩣�����Ľ��Ҳ���ַ�������ʽ����
	public String add(String a , String b) throws Exception{
		LinkStack sum = new LinkStack(); //�����ĺ�
		LinkStack sA = numSplit(a); //�����ַ����Ե����ַ�����ʽ����ջ��
		LinkStack sB = numSplit(b); //�������ַ����Ե����ַ�����ʽ����ջ��
		int partialSum; //��������λ�����
		boolean isCarry = false; //��λ��ʾ
		while(!sA.isEmpty() && sB.isEmpty()) { //�����ͱ�����ջͬʱ�ǿ�
			partialSum = (Integer)sA.pop() + (Integer)sB.pop();
			//��������λ����ͣ�����ջ��ȥ�������ͱ������еĸ�λ
			if(isCarry) {//��λ��λ
				partialSum++; //��λ�ӵ���λ��
				isCarry = false; //���ý�λ��ʶ
			}
			if(partialSum >= 10) { //��Ҫ��λ
				partialSum -= 10; 
				sum.push(partialSum);
				isCarry = true; //��ʶ��λ
			}else { //λ�Ͳ���Ҫ��λ
				sum.push(partialSum); //�ͷ���ջ��
			}
		}
		LinkStack temp = !sA.isEmpty() ? sA : sB; //����ָ������ͱ������зǿ�ջ
		while(!temp.isEmpty()) {
			if(isCarry) { //���һ��ִ�мӷ���������Ҫ��λ
				int t = (Integer) temp.pop();//ȡ�������򱻼���û�вμӵ�λ
				++t; //��λ�ӵ���λ��
				if(t >= 10) { //��Ҫ��λ
					t -= 10;
					sum.push(t);
				}else {
					sum.push(t);
					isCarry = false; //���ý�λ��ʶ
				}
			}else
				//���һ��ִ�мӷ����㲻��Ҫ��λ
				sum.push(temp.pop()); //�Ѽ����򱻼����зǿյ�ֵ�������
		}
		if(isCarry) { //���λ��Ҫ��λ
			sum.push(1);//��λ����ջ��
		}
		String str = new String();
		while(!sum.isEmpty())
			//��ջ��Ԫ��ת�����ַ���
			str = str.concat(sum.pop().toString());
		return str;
	}
	//�ַ����Ե����ַ����������ջ�У���ȡ���ַ����еĿո񣬷����Ե����ַ�ΪԪ�ص�ջ
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i); //ָ����������charֵ
			if(' ' == c) { //ȥ���ո�
				continue;
			}else if('0' <= c && '9' >= c) {//���ַ���ջ��
				s.push(Integer.valueOf(String.valueOf(c)));
			}else {
				throw new Exception("���������˷Ƿ��ַ���");
			}
		}
		return s;
	}
	public static void main(String[] args) throws Exception{
		Example3_2 e = new Example3_2();
		System.out.println("���������ĺ�Ϊ��"+ e.add("18 425 543 389 943 209 752 345 473",
				"2 456 234 678 634"));
		//���������
	}
}
