package Josephus01;
import java.util.Scanner;


public class JosephusP {
	public void count(int n, int k) {
		Node tail = null; //β���
		for(int i = 1; i<n; i++) {
			Node node = new Node(i);//�����µĽ��
		    if (tail == null) {
		        tail = node;
		        node.next=tail;
		        return ;
		    }
		    node.next=tail.next;//�½��ָ��ͷ��
		    tail.next=node;//����β���
		    tail=node;//�滻β���
		}
		Node p = tail.next;//pָ��β������һ����㣬����һ�����
		//ѭ������������������ֻʣ��һ����㣬��p.next = p
		while(p.next!=p) {
			//����
			for(int i = 1; i<k-1; i++) {
				p = p.next;
			}
			//�ҵ���k����ʱ����ѭ��������ý��
			System.out.print(p.next.data+" ");
			//ֱ��ɾ�����еĽ��
			p.next = p.next.next;
			p = p.next;
		}
		System.out.println();//����
		//���ʣ�µĽ��
		System.out.println("(left:"+p.data+")");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JosephusP j = new JosephusP();
		System.out.println("Please input the size of the linklist:");
		int n = sc.nextInt();
		System.out.println("Please input the password:");
		int k = sc.nextInt();
		j.count(n, k);
	}
}
