package Josephus;
import java.util.Scanner;
public class JosephusJ {

	public static void count(int n,int k){
		//����k���֣��м���k-1����
		//ͷ��㲻�洢����
		Node head = new Node();
		Node cur = head;
		//ѭ�������������
		for(int i=1;i<=n;i++){//����Ԫ��Ϊ��1��n
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		//���������ݵĲ�����β�����γ�һ������
		cur.next = head.next;
		//pָ���һ�����
		Node p = head.next;
		//ѭ���˳������������ֻʣһ����㣬Ҳ�������������һ�������������
		while(p.next!=p){
			//���������ı����߼�
			for(int i=1;i<k-1;i++){
				p = p.next;
			}
			//������k��ʱ�򣬳���
			System.out.print(p.next.data+"->");
			p.next = p.next.next;
			p = p.next;
		}
		System.out.println();//����
		//���ʣ�µ�һ�����
		System.out.println("(left:"+p.data+")");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the size of the LinkList :");
		int n = sc.nextInt();
		System.out.println("Please input a number k between 1 and 9:");
		int k = sc.nextInt();
		count(n,k);
	}
}