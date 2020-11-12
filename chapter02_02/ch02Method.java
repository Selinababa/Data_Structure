package chapter02_02;//����������������Ӽ�����

import java.util.Scanner;

public class ch02Method implements ch02List{
	public Node head;//�����ͷָ��
	
	//����Ĺ��캯��
	public ch02Method() {
		head = new Node();
	}
	//����һ������Ϊn�ĵ�����
	public ch02Method(int n, boolean order) throws Exception{
		this();
		if(order) {
			create02(n);
		}
		else {
			create01(n);
		}
	}
	//ͷ�巨���쵥����
	public void create01(int n) throws Exception {
		Scanner sc = new Scanner(System.in);
		for(int j=0; j<n; j++) {
			insert(0,sc.next());
		}
	}
	//β�巨���쵥����
	public void create02(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j=0; j<n; j++) {
			insert(length(), sc.next());
		}
	}
	//��Ԫ��x���뵽�������λ��i
	public void insert(int i, Object x) throws Exception {
		Node p = head;
		int j=-1;
		while(p!=null && j<i-1){
			p = p.next;
			++j;
		}
		if(j>i-1 || p == null) {
			throw new Exception("����λ�ò��Ϸ���");
		}
		Node s = new Node(x);
		s.next = p.next;
		p.next = s;
	}
	//��ȡ����ĳ���
	public int length() {
		Node p = head.next;
		int length = 0;
		while(p!=null) {
			p = p.next;
			++length;
		}
		return length;
	}
	//���������
	public void display() {
		Node node = head.next;
		while(node != null) {
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
	//��ȡ�������еĵ�i��Ԫ��
	public Object get(int i) throws Exception{
		Node p = head.next;
		int j = 0;
		while(p!=null && j<i) {
			p = p.next;
			++j;
		}
		if(j>i || p==null) {
			throw new Exception("��"+i+"��Ԫ�ز����ڣ�");
		}
		return p.data;
	}
	//����ϲ�����������
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

	//ɾ�������еĴ�д��ĸ??
	public void delete() {
		Node p = head;//pָ��ͷ��㣬jΪ������
		for(int j=0; j<16; j++) {
			if(p.next!=null && j%2!=1) {
				p = p.next;
				++j;
			}
			p.next = p.next.next;
		}
	}
	//ԭ�����浥����
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
		ch02Method ch = new ch02Method();//chΪ�ϳ�����
		

		//һ.�������������ֱ������Сд��a��h
		int m =8;
		System.out.println("Please input the first LinkList:");
		ch02Method con1 = new ch02Method(m, true);//���ù��캯��

		System.out.println("Please input the second LinkList:");
		ch02Method con2 = new ch02Method(m, true);
		
		//��.�ϲ������������
		System.out.println("The merged LinkList is: ");
		ch.merge(con1, con2, ch);		//���ú���merge���ϲ���������
		ch.display();		//���ú���display���������
		
		//��.ԭ�����棬�����
		System.out.println("The reversed linkList is: ");
		ch.reverse();
		ch.display();
		
		//��.ɾ����д��ĸ�������
		System.out.println("The final LinkList is:");
		ch.delete();
		ch.display();
	}
}
