package Josephus;
import java.util.Scanner;
public class JosephusJ {

	public static void count(int n,int k){
		//数到k出局，中间间隔k-1个人
		//头结点不存储数据
		Node head = new Node();
		Node cur = head;
		//循环构造这个链表
		for(int i=1;i<=n;i++){//链表元素为从1到n
			Node node = new Node(i);
			cur.next = node;
			cur = node;
		}
		//链表有数据的部分首尾相连形成一个环。
		cur.next = head.next;
		//p指向第一个结点
		Node p = head.next;
		//循环退出的条件是最后只剩一个结点，也就是这个结点的下一个结点是它本身
		while(p.next!=p){
			//正常报数的遍历逻辑
			for(int i=1;i<k-1;i++){
				p = p.next;
			}
			//当数到k的时候，出局
			System.out.print(p.next.data+"->");
			p.next = p.next.next;
			p = p.next;
		}
		System.out.println();//换行
		//最后剩下的一个结点
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