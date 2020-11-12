package DS01;
public class Node01 {
	public Object data;//存放结点值
	public Node01 next;//后继结点的引用
	public Object Next;
	//无参数时的构造函数
	public Node01() {
		this(null, null);
	}
	//带一个参数时的构造函数
	public Node01(Object data) {
		this(data, null);
	}
	//带两个参数时的构造函数
	public Node01(Object data, Node01 next) {
		this.data = data;
		this.next = next;
	}
}
