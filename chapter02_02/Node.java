package chapter02_02;

public class Node {
	
	public Object data;//��Ž��ֵ
	public Node next;//��̽�������
	
	//�޲���ʱ�Ĺ��캯��
	public Node() {
		this(null, null);
	}
	//��һ������ʱ�Ĺ��캯��
	public Node(Object data) {
		this(data, null);
	}
	//����������ʱ�Ĺ��캯��
	public Node(Object data, Node next) {
		this.data = data;
		this.next = next;
	}
}
