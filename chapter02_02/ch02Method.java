package chapter02_02;//韩冬：单链表的链接及置逆

import java.util.Scanner;

public class ch02Method implements ch02List{
	public Node head;//链表的头指针
	
	//链表的构造函数
	public ch02Method() {
		head = new Node();
	}
	//构造一个长度为n的单链表
	public ch02Method(int n, boolean order) throws Exception{
		this();
		if(order) {
			create02(n);
		}
		else {
			create01(n);
		}
	}
	//头插法构造单链表
	public void create01(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int j=0; j<n; j++) {
			insert(0,sc.next());
		}
	}
	//尾插法构造单链表
	public void create02(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j=0; j<n; j++) {
			insert(length(), sc.next());
		}
	}
	//将元素x插入到单链表的位置i
	public void insert(int i, Object x) throws Exception {
		Node p = head;
		int j=-1;
		while(p!=null && j<i-1){
			p = p.next;
			++j;
		}
		if(j>i-1 || p == null) {
			throw new Exception("插入位置不合法！");
		}
		Node s = new Node(x);
		s.next = p.next;
		p.next = s;
	}
	//获取链表的长度
	public int length() {
		Node p = head.next;
		int length = 0;
		while(p!=null) {
			p = p.next;
			++length;
		}
		return length;
	}
	//输出单链表
	public void display() {
		Node node = head.next;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
	//获取单链表中的第i个元素
	public Object get(int i) throws Exception{
		Node p = head.next;
		int j = 0;
		while(p!=null && j<i) {
			p = p.next;
			++j;
		}
		if(j>i || p==null) {
			throw new Exception("第"+i+"个元素不存在！");
		}
		return p.data;
	}
	//交叉合并两个单链表
	public void merge(ch02Method h1, ch02Method h2,ch02Method m) throws Exception {
		//ch02Method m = new ch02Method();
		for(int j=0; j<16; j++) {
			if(j%2==0) {
				Object y = h1.get(j/2);
				m.insert(j, y);
			}else if(j%2==1) {
				Object r = h2.get((j-1)/2);
				m.insert(j, r);
			}
		}
	}

	//删除链表中的大写字母??
	public void delete() {
		Node p = head;//p指向头结点，j为计数器
		for(int j=0; j<16; j++) {
			if(p.next!=null && j%2!=1) {
				p = p.next;
				++j;
			}
			p.next = p.next.next;
		}
	}
	//原地置逆单链表
	public void reverse() {
		Node p = head.next;
		head.next = null;
		Node q;
		while(p!=null) {
			q = p.next;
			p.next = head.next;
			head.next = p;
			p = q;
		}
	}
	
	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		Node head = new Node();
		ch02Method ch = new ch02Method();//ch为合成链表
		

		//一.建立两个链表，分别输入大小写的a到h
		int m =8;
		System.out.println("Please input the first LinkList:");
		ch02Method con1 = new ch02Method(m, true);//调用构造函数

		System.out.println("Please input the second LinkList:");
		ch02Method con2 = new ch02Method(m, true);
		
		//二.合并链表，并输出：
		System.out.println("The merged LinkList is: ");
		ch.merge(con1, con2, ch);		//调用函数merge，合并两个链表
		ch.display();		//调用函数display，输出链表
		
		//三.原地置逆，并输出
		System.out.println("The reversed linkList is: ");
		ch.reverse();
		ch.display();
		
		//四.删除大写字母，并输出
		System.out.println("The final LinkList is:");
		ch.delete();
		ch.display();
	}
}
