package Chapter03_01;
import Chapter03_01.Node;
public class LinkStack implements IStack{
	private Node top;  //栈顶元素到引用
	//栈置空
	public void clear() {
		top = null;
	}
	//判空
	public boolean isEmpty() {
		return top == null;
	}
	//求链栈的长度
	public int length() {
		Node p = top;
		int length = 0;
		while(p!=null) {
			p = p.next;
			++length;
		}
		return length;
	}

	//求栈顶元素并返回其值
	public Object peek() {
		if(!isEmpty())
			return top.data; //返回栈顶元素的值
		else
			return null;
	}

	//入栈
	public void push(Object x) throws Exception {
		Node p = new Node(x);
		p.next = top;
		top = p; //新结点成为当前的栈顶结点
	}

	//出栈
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

	//输出栈中所有数据元素（从栈顶元素到栈底元素）
	public void display() {
		Node p = top;
		while(p!=null) {
			System.out.print((p.data.toString() + " "));
			p = p.next;
		}
	}
}
