package Josephus01;
import java.util.Scanner;


public class JosephusP {
	public void count(int n, int k) {
		Node tail = null; //尾结点
		for(int i = 1; i<n; i++) {
			Node node = new Node(i);//产生新的结点
		    if (tail == null) {
		        tail = node;
		        node.next=tail;
		        return ;
		    }
		    node.next=tail.next;//新结点指向头部
		    tail.next=node;//连接尾结点
		    tail=node;//替换尾结点
		}
		Node p = tail.next;//p指向尾结点的下一个结点，即第一个结点
		//循环结束的条件是链表只剩下一个结点，即p.next = p
		while(p.next!=p) {
			//遍历
			for(int i = 1; i<k-1; i++) {
				p = p.next;
			}
			//找到第k个数时结束循环，输出该结点
			System.out.print(p.next.data+" ");
			//直接删除出列的结点
			p.next = p.next.next;
			p = p.next;
		}
		System.out.println();//换行
		//最后剩下的结点
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
