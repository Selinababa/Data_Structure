package Chapter03_01;

public class SqStack implements IStack{
	
	private Object[] stackElem; //��������
	private int top; //�ڷǿ�ջ�У�topʼ��ָ��ջ��Ԫ�ص���һ���洢λ�ã���ջΪ��ʱ��topֵΪ0
	//ջ�Ĺ��캯��������һ���洢�ռ�����ΪmaxSize�Ŀ�ջ
	public SqStack(int maxSize) {
		top = 0; //��ʼ��topΪ0
		stackElem = new Object [maxSize];//Ϊջ����maxSize���洢��Ԫ
	}
	//ջ�ÿ�
	public void clear() {
		top = 0;
	}
	//�п�
	public boolean isEmpty() {
		return top == 0;
	}
	//��ջ������Ԫ�صĸ���
	public int length() {
		return top;
	}
	//ȡջ��Ԫ��
	public Object peek() {
		if(!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}
	//��ջ
	public void push(Object x) throws Exception {
		if(top == stackElem.length)//ջ��
			throw new Exception("ջ����");
		else
			stackElem[top++] = x;
	}
	//��ջ
	public Object pop() {
		if(isEmpty())
			return null;
		else
			return stackElem[--top];
	}
	//���ջ����������Ԫ�أ���ջ��Ԫ�ص�ջ��Ԫ�أ�
	public void display() {
		for(int i = top-1; i>=0; i--)
			System.out.print(stackElem[i].toString()+" ");
	}
}
