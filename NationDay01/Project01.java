package NationDay01;
import java.util.*;
import java.math.*;

public class Project01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//两个数的存储
		int a[] = new int [10];//新建一个数组用于存放第一个乘数
		int b[] = new int [10];//用于存放第二个乘数
		System.out.println("请输入两个乘数的位数：");
		int l1 = input.nextInt();
		int l2 = input.nextInt();
		System.out.println("请输入第一个不大于10位的乘数：");
		for(int i=l1-1 ; i>=0; i--) {//循环输入第一个乘数，存放进数组a
			a[i] = input.nextInt();
		}
		System.out.println("请输入第二个不大于10位的乘数：");
		for(int j=l2-1 ; j>=0; j--) {//循环输入第二个乘数，存放进数组b
			b[j] = input.nextInt();
		}
		//进行两个数相乘：
		for(int x=0; x<b.length; x++) {//第一层循环是第二个乘数
			for(int y=0; y<a.length; y++) {//第二层循环是第一个乘数
				int temp01=0;//变量temp01用于存放乘法进位数字
				int temp02=0;//变量temp02用于存放加法进位的数字
				int c[] = new int[11];//定义一个数组用于存放结果
				int re = b[x] * a[y];//re用于暂时存放两数相乘的结果
				c[y] = c[y] + (re + temp01)%10;
				temp01 = re / 10;
				temp02 = c[y] / 10;
			}//第二层循环结束时，完成了第二个乘数与第一个乘数各个位数的乘法计算
		}//第一层循环结束时，完成了两个乘数的相乘和相加
	}
	
}
