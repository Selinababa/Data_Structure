package Chapter03_01;
import java.util.Scanner;
public class Hanoi {
	
	private static int c = 0;//全局变量，对搬动技术
	
	//将塔座x上按直径由大到小且自上而下的编号为1至n的n个圆盘按规则移动到塔座z上
	//y用作辅助塔座
	public  void hanoi(int n, char x, char y, char z) throws Exception{
		
		if(n == 1) {
			move(x,1,z);//将编号为1的圆盘从x移到z
			
		}else {
			hanoi(n-1, x, z, y); //将x上编号为1至n-1的圆盘移动到y，z作辅助塔座
			move(x, n, z); //将编号为n到圆盘从x移动到z
			hanoi(n-1, y, x, z); //将y上编号为1至n-1的圆盘移动到z，x作辅助塔座
		}
	}
	//移动操作，将编号为n的圆盘从x移动到z
	public void move(char x, int n, char z) {
		System.out.println("第" + ++c + "次移动" +n+ "号圆盘" +x+ "->" +z);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Hanoi h = new Hanoi();
		int n = -1;//n为圆盘的个数
		char x = 0;//新建三个字符变量代表三个塔座
		char y = 0;
		char z = 0;
		while(n != 0) {
			System.out.println("请输入圆盘的个数n(输入0时结束程序):");
			n = sc.nextInt();
			c = 0;
			h.hanoi(n, 'x', 'y', 'z');//调用函数移动圆盘
		}
	}
}
