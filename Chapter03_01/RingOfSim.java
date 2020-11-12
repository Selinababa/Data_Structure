package Chapter03_01;
import Chapter03_01.LinkQueue;
import DS01.SqList;

public class RingOfSim { //将1~n的n个自然数排列成环形，使得每相邻两数之和为素数，从而构成一个素数环
	
	private static int n;//新建一个全局变量n，为素数环内自然数的个数
	public static void main(String[] args) throws Exception {
		SqList L = new SqList(n);  //顺序表用于存放素数环 (SqList类的构造函数含参，参数为一个整型变量或整数)
		LinkQueue Q = new LinkQueue();//队列用于存放还未加入到素数环中的自然数
		
		//初始化顺序表L：将1加入到顺序表L中
		L.insert(0,1);
		//初始化队列Q：将2~n的自然数全部加入到Q队列中
		for(int i = 2; i<n; i++) {
			Q.offer(i);
		}
	}
}
