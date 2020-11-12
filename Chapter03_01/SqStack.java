package Chapter03_01;

public class SqStack implements IStack{
	
	private Object[] stackElem; //对象数组
	private int top; //在非空栈中，top始终指向栈顶元素的下一个存储位置；当栈为空时，top值为0
	//栈的构造函数，构造一个存储空间容量为maxSize的空栈
	public SqStack(int maxSize) {
		top = 0; //初始化top为0
		stackElem = new Object [maxSize];//为栈分配maxSize个存储单元
	}
	//栈置空
	public void clear() {
		top = 0;
	}
	//判空
	public boolean isEmpty() {
		return top == 0;
	}
	//求栈中数据元素的个数
	public int length() {
		return top;
	}
	//取栈顶元素
	public Object peek() {
		if(!isEmpty())
			return stackElem[top - 1];
		else
			return null;
	}
	//入栈
	public void push(Object x) throws Exception {
		if(top == stackElem.length)//栈满
			throw new Exception("栈已满");
		else
			stackElem[top++] = x;
	}
	//出栈
	public Object pop() {
		if(isEmpty())
			return null;
		else
			return stackElem[--top];
	}
	//输出栈中所有数据元素（从栈顶元素到栈底元素）
	public void display() {
		for(int i = top-1; i>=0; i--)
			System.out.print(stackElem[i].toString()+" ");
	}
}
