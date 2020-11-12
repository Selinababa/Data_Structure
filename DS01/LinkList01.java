package DS01;
import java.util.Scanner;

import javafx.scene.Node;
public class LinkList01 implements Ilist {
	Node01 no = new Node01();
	public Node01 head;//单链表的头指针
	
	public LinkList01() {	//单链表的构造函数
		head = new Node01();	//初始化头结点
	}
	public LinkList01 (int n, boolean Order) throws Exception{//构造一个长度为n的单链表
		this();//初始化头结点
		if(Order) //用尾插法顺序建立单链表
			create1(n);
		else //用头插法逆位序建立单链表
			create2(n);
	}
	//用尾插法顺序建立单链表，其中n为单链表的结点个数
	public void create1(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j<n; j++) //输入n个结点的数据域值
			insert(length(), sc.next()); //生成新结点，插入到表尾
	}
	
	//用头插法逆位序建立单链表，其中n为单链表的节点个数
	public void create2(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j<n; j++) //逆序输入n个结点的数据阈值
			insert(0,sc.next());//生成新结点，插入到表头
	}
	
	//将一个已经存在的带头结点的单链表置成空表
	public void clear() {
		head.data = null;
		head.next = null;
	}
	
	//判断带头结点的单链表是否为空
	public boolean isEmpty() {
		return head.next == null;
	}
	
	//求带头结点的单链表的长度
	public int length() {
		Node01 p = head.next;	//初始化，p指向头结点，length为计数器
		int length = 0;
		while(p!=null) {	//从首结点开始向后查找，直到p为空
			p = p.next;	//只想后继结点
			++length;//长度增加1
		}
		return length;
	}
	
	//读取带头结点的单链表中的第i个结点
	public Object get(int i) throws Exception{
		Node01 p = head.next; //初始化，p指向首结点，j为计数器
		int j = 0;
		while(p!=null && j<i) { //从首结点开始向后查找，直到p指向第i个结点或p为空
			p = p.next; //指向后继结点
			++j; //计数器的值加1
		}
		if(j>i || p==null) {
			throw new Exception("There is no "+i+" character!"); //抛出异常
		}
		else
			System.out.println("The "+(i+1)+" character is "+p.data);
		return p.data; //返回结点p的数据阈值
	}
	
	//在单链表的第i个元素之前插入一个值为x的新元素
	public void insert(int i, Object x) throws Exception {
		Node01 p = head;//初始化p为头结点，j为计数器
		int j = -1;
		while(p!=null && j<i-1) { //寻找第i个结点的前驱
			p = p.next;
			++j;  //计数器的值加1
		}
		if(j>i-1 || p==null)//i不合法
			throw new Exception("The location you insert the new character is illegal!");
		Node01 s = new Node01(x); //生产新节点
		s.next = p.next; //修改链，使新结点插入单链表中
		p.next = s;
	}
	
	//删除单链表中第i个元素
	public void remove(int i) throws Exception {
		Node01 p = head; //初始化p指向头结点，j为计数器
		int j = -1;
		while(p.next!=null && j<i-1) { //寻找第i个结点的前驱
			p = p.next;
			++j;
		}
		if(j>i-1 || p.next == null) {
			throw new Exception("The point you delete is illegal!");
		}
		p.next = p.next.next; //修改链指针，使待删除结点从单链表中脱离出来
	}
	
	//在单链表中查找值为y的元素
	public int indexOf(Object x) {
		Node01 p = head.next;//初始化，p只想首结点，j为计数器
		int j = 0;
		//从单链表的首结点开始查找，知道p.data为x或到达单链表的表尾
		while(p!=null&& !p.data.equals(x)) {
			p = p.next; 	//指向下一个结点
			++j;	//计数器的值加1
		}
		if(p!=null) {
			return j;
		}	
		else {
			return -1;
		}
	}
	
	//输出单链表中的所有结点
	public void display() {
		Node01 node = head.next;	//取出带头结点的单链表中的首结点
		while(node!=null) {
			System.out.print(node.data + " ");//输出结点的值
			node = node.next;	//取下一个结点
		}
		System.out.println();//换行
	}
	
	//删除单链表中重复的结点
	public void delete_same(LinkList01 L) throws Exception {
		Node01 p = head.next, q; //初始化，p指向首结点
		while(p!=null) {
			int order = indexOf(p.data); //记录p在单链表中的位置
			q = p.next; 
			while(q != null) { //与p的所有后继结点进行比较
				if((p.data).equals(q.data)) //删除重复的结点
					remove(order + 1);
				else
					++order;
				q = q.next;
			}
			p = p.next;
		}
	}
	
	//将单链表就地置逆 
	public void reverse() {
		Node01 p = head.next;
		head.next = null;
		Node01 q;
		while(p!=null) {
			q = p.next;
			p.next = head.next;
			head.next = p;
			p = q;
		}
	}
}