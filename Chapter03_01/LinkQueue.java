package Chapter03_01;
import Chapter03_01.Node;

public class LinkQueue implements IQueue{
	private Node front; //队首指针
	private Node rear;  //队尾指针
	//链队列类的构造函数
	
	public LinkQueue() {
		front = rear = null;
	}
	
	//队列置空
	public void clear() {
		front = rear = null;
	}

	//队列判空
	public boolean isEmpty() {
		return front == rear;
	}

	//求队列的长度
	public int length() {
		Node p = front;
		int length = 0;
		while(p != null) {
			p = p.next; //指针下移
			++length; //计数器加一
		}
		return length;
	}

	//取队首元素
	public Object peek() {
		if(front != rear) { //队列非空
			return front.data; //返回队首结点的数据域值
		}else
			return null;
	}

	//入队
	public void offer(Object x) throws Exception {
		Node p = new Node(x); //初始化新结点
		if(front != null) { //队列非空
			rear.next = p;
			rear = p; //改变队列位置
		}
		else
			front = rear = p;
	}

	//出队
	public Object poll() {
		if(front != null) { //队列非空
			Node p = front; //p指向队首结点
			front = front.next; //队首结点出列
			if(p == rear) { //被删除结点是队尾结点时
				rear = null;
			}
			return p.data;//返回队首结点的数据域值
		}else
			return null;
	}

}
