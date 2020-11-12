package Chapter03_01;

public class CircleSqQueue implements IQueue{
	private Object[] queueElem; //���д洢�ռ�
	private int front; //���׵����ã������в��գ�ָ�����Ԫ��
	private int rear;//��β�����ã������в��գ�ָ���βԪ�ص���һ���洢λ��
	//ѭ�����еĹ��캯��
	public CircleSqQueue(int maxSize) {
		front = rear = 0;//���ף���β��ʼ��Ϊ0
		queueElem = new Object[maxSize]; //Ϊ���з���maxSize���洢��Ԫ
	}
	//�����ÿ�
	public void clear() {
		front = rear = 0;
	}

	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return front == rear;
	}

	//����еĳ���
	public int length() {
		return (rear - front + queueElem.length) % queueElem.length;
	}

	//��ȡ����Ԫ��
	public Object peek() {
		if(front == rear) { //����Ϊ��
			return null;
		}else {
			return queueElem[front]; //���ض���Ԫ��
		}
	}

	//���
	public void offer(Object x) throws Exception {
		if((rear + 1) % queueElem.length == front)//������
			throw new Exception("��������");
		else {
			queueElem[rear] = x;//x����rear��ָ������洢λ���У�ʹ���Ϊ�µĶ�βԪ��
			rear = (rear + 1) % queueElem.length; //�޸Ķ�βָ��
		}
	}

	//����
	public Object poll() {
		if(front == rear) //����Ϊ��
			return null;
		else {
			Object t = queueElem[front];
			front = (front + 1) % queueElem.length;
			return t; //���ض��еĶ���Ԫ��
		}
	}

	//���������������Ԫ�أ��Ӷ��׵���β��
	public void display() {
		if(!isEmpty()) {
			for(int i = front; i != rear; i = (i+1) % queueElem.length) {
				System.out.print(queueElem[i].toString() + " ");
			}
		}else {
			System.out.println("�˶���Ϊ��");
		}
	}
}
