package DS01;
import java.util.Scanner;

import javafx.scene.Node;
public class LinkList01 implements Ilist {
	Node01 no = new Node01();
	public Node01 head;//�������ͷָ��
	
	public LinkList01() {	//������Ĺ��캯��
		head = new Node01();	//��ʼ��ͷ���
	}
	public LinkList01 (int n, boolean Order) throws Exception{//����һ������Ϊn�ĵ�����
		this();//��ʼ��ͷ���
		if(Order) //��β�巨˳����������
			create1(n);
		else //��ͷ�巨��λ����������
			create2(n);
	}
	//��β�巨˳��������������nΪ������Ľ�����
	public void create1(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j<n; j++) //����n������������ֵ
			insert(length(), sc.next()); //�����½�㣬���뵽��β
	}
	
	//��ͷ�巨��λ��������������nΪ������Ľڵ����
	public void create2(int n) throws Exception{
		Scanner sc = new Scanner(System.in);
		for(int j = 0; j<n; j++) //��������n������������ֵ
			insert(0,sc.next());//�����½�㣬���뵽��ͷ
	}
	
	//��һ���Ѿ����ڵĴ�ͷ���ĵ������óɿձ�
	public void clear() {
		head.data = null;
		head.next = null;
	}
	
	//�жϴ�ͷ���ĵ������Ƿ�Ϊ��
	public boolean isEmpty() {
		return head.next == null;
	}
	
	//���ͷ���ĵ�����ĳ���
	public int length() {
		Node01 p = head.next;	//��ʼ����pָ��ͷ��㣬lengthΪ������
		int length = 0;
		while(p!=null) {	//���׽�㿪ʼ�����ң�ֱ��pΪ��
			p = p.next;	//ֻ���̽��
			++length;//��������1
		}
		return length;
	}
	
	//��ȡ��ͷ���ĵ������еĵ�i�����
	public Object get(int i) throws Exception{
		Node01 p = head.next; //��ʼ����pָ���׽�㣬jΪ������
		int j = 0;
		while(p!=null && j<i) { //���׽�㿪ʼ�����ң�ֱ��pָ���i������pΪ��
			p = p.next; //ָ���̽��
			++j; //��������ֵ��1
		}
		if(j>i || p==null) {
			throw new Exception("There is no "+i+" character!"); //�׳��쳣
		}
		else
			System.out.println("The "+(i+1)+" character is "+p.data);
		return p.data; //���ؽ��p��������ֵ
	}
	
	//�ڵ�����ĵ�i��Ԫ��֮ǰ����һ��ֵΪx����Ԫ��
	public void insert(int i, Object x) throws Exception {
		Node01 p = head;//��ʼ��pΪͷ��㣬jΪ������
		int j = -1;
		while(p!=null && j<i-1) { //Ѱ�ҵ�i������ǰ��
			p = p.next;
			++j;  //��������ֵ��1
		}
		if(j>i-1 || p==null)//i���Ϸ�
			throw new Exception("The location you insert the new character is illegal!");
		Node01 s = new Node01(x); //�����½ڵ�
		s.next = p.next; //�޸�����ʹ�½����뵥������
		p.next = s;
	}
	
	//ɾ���������е�i��Ԫ��
	public void remove(int i) throws Exception {
		Node01 p = head; //��ʼ��pָ��ͷ��㣬jΪ������
		int j = -1;
		while(p.next!=null && j<i-1) { //Ѱ�ҵ�i������ǰ��
			p = p.next;
			++j;
		}
		if(j>i-1 || p.next == null) {
			throw new Exception("The point you delete is illegal!");
		}
		p.next = p.next.next; //�޸���ָ�룬ʹ��ɾ�����ӵ��������������
	}
	
	//�ڵ������в���ֵΪy��Ԫ��
	public int indexOf(Object x) {
		Node01 p = head.next;//��ʼ����pֻ���׽�㣬jΪ������
		int j = 0;
		//�ӵ�������׽�㿪ʼ���ң�֪��p.dataΪx�򵽴ﵥ����ı�β
		while(p!=null&& !p.data.equals(x)) {
			p = p.next; 	//ָ����һ�����
			++j;	//��������ֵ��1
		}
		if(p!=null) {
			return j;
		}	
		else {
			return -1;
		}
	}
	
	//����������е����н��
	public void display() {
		Node01 node = head.next;	//ȡ����ͷ���ĵ������е��׽��
		while(node!=null) {
			System.out.print(node.data + " ");//�������ֵ
			node = node.next;	//ȡ��һ�����
		}
		System.out.println();//����
	}
	
	//ɾ�����������ظ��Ľ��
	public void delete_same(LinkList01 L) throws Exception {
		Node01 p = head.next, q; //��ʼ����pָ���׽��
		while(p!=null) {
			int order = indexOf(p.data); //��¼p�ڵ������е�λ��
			q = p.next; 
			while(q != null) { //��p�����к�̽����бȽ�
				if((p.data).equals(q.data)) //ɾ���ظ��Ľ��
					remove(order + 1);
				else
					++order;
				q = q.next;
			}
			p = p.next;
		}
	}
	
	//��������͵����� 
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