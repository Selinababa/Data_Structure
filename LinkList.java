package chapter02_03;//������
import java.util.*;

public class LinkList {
	public Node head1;//��������ͷ���
	public Node head2;
	public Node head5;//�������������ͷ���
	
	public int pos = 0;//����λ��
	
	private Object next;
	
	public void create(int m){//����������ĺ���
		Scanner sc = new Scanner(System.in);
		
		for(int j=0; j<m; j++) {
			insert(this.next , sc.next());
		}
	}

	private void insert(Object next2, String next3) {
		// TODO Auto-generated method stub
		
	}
	
	public static Node merge(Node head1, Node head2) {
		if(head1==null && head2==null) {
			return null;
		}
		if(head1 == null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		Node head = null;
		if(head1.data>head2.data) {
			head = head2;
			head.next = merge(head1.next, head2);
		}else {
			head = head1;
			head.next = merge(head1.next,head2);
		}
		return head;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
	}
}
