package DS01;
public class Node01 {
	public Object data;//��Ž��ֵ
	public Node01 next;//��̽�������
	public Object Next;
	//�޲���ʱ�Ĺ��캯��
	public Node01() {
		this(null, null);
	}
	//��һ������ʱ�Ĺ��캯��
	public Node01(Object data) {
		this(data, null);
	}
	//����������ʱ�Ĺ��캯��
	public Node01(Object data, Node01 next) {
		this.data = data;
		this.next = next;
	}
}
