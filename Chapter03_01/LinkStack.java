package Chapter03_01;
import Chapter03_01.Node;
public class LinkStack implements IStack{
	private Node top;  //ջ��Ԫ�ص�����
	//ջ�ÿ�
	public void clear() {
		top = null;
	}
	//�п�
	public boolean isEmpty() {
		return top == null;
	}
	//����ջ�ĳ���
	public int length() {
		Node p = top;
		int length = 0;
		while(p!=null) {
			p = p.next;
			++length;
		}
		return length;
	}

	//��ջ��Ԫ�ز�������ֵ
	public Object peek() {
		if(!isEmpty())
			return top.data; //����ջ��Ԫ�ص�ֵ
		else
			return null;
	}

	//��ջ
	public void push(Object x) throws Exception {
		Node p = new Node(x);
		p.next = top;
		top = p; //�½���Ϊ��ǰ��ջ�����
	}

	//��ջ
	public Object pop() {
		if(isEmpty()) {
			return null;
		}
		else {
			Node p = top;
			top = top.next;
			return p.data;
		}
	}

	//���ջ����������Ԫ�أ���ջ��Ԫ�ص�ջ��Ԫ�أ�
	public void display() {
		Node p = top;
		while(p!=null) {
			System.out.print((p.data.toString() + " "));
			p = p.next;
		}
	}
}
