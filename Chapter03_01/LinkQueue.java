package Chapter03_01;
import Chapter03_01.Node;

public class LinkQueue implements IQueue{
	private Node front; //����ָ��
	private Node rear;  //��βָ��
	//��������Ĺ��캯��
	
	public LinkQueue() {
		front = rear = null;
	}
	
	//�����ÿ�
	public void clear() {
		front = rear = null;
	}

	//�����п�
	public boolean isEmpty() {
		return front == rear;
	}

	//����еĳ���
	public int length() {
		Node p = front;
		int length = 0;
		while(p != null) {
			p = p.next; //ָ������
			++length; //��������һ
		}
		return length;
	}

	//ȡ����Ԫ��
	public Object peek() {
		if(front != rear) { //���зǿ�
			return front.data; //���ض��׽���������ֵ
		}else
			return null;
	}

	//���
	public void offer(Object x) throws Exception {
		Node p = new Node(x); //��ʼ���½��
		if(front != null) { //���зǿ�
			rear.next = p;
			rear = p; //�ı����λ��
		}
		else
			front = rear = p;
	}

	//����
	public Object poll() {
		if(front != null) { //���зǿ�
			Node p = front; //pָ����׽��
			front = front.next; //���׽�����
			if(p == rear) { //��ɾ������Ƕ�β���ʱ
				rear = null;
			}
			return p.data;//���ض��׽���������ֵ
		}else
			return null;
	}

}
