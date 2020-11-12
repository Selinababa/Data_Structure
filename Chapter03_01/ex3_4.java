package Chapter03_01;
import java.util.*;
public class ex3_4 {//判断输入的算术表达式是否正确，并计算其值后输出
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ex3_3Calculate cal = new ex3_3Calculate();
		
		System.out.println("请输入算术表达式："); //提示输入
		String n = sc.next(); //算术表达式为一串字符串
		
		isComplete(n); //调用函数判断输入是否完成

		//循环：判断表达式是否输入完成，若不完成则继续提示输入：
		while(!isComplete(n)) {
			System.out.println("错误！输入未完成：存在未匹配的括号！请继续输入：");
			n = n + sc.next();//将第一次输入的n与第二次输入的n连接起来
			
		}//循环结束条件为 输入已完成，即所有括号都完成匹配
		
		String n2 = cal.convertToPostfix(n);//调用函数将算数表达式转换为后缀表达式，并将后缀表达式赋给n2
		System.out.println(n2);//输出后缀表达式n2
		
		System.out.println(cal.numberCalculate(n2));//调用函数计算后缀表达式，并输出结果
	}
	
	//用于判断输入是否完成的函数，即判断左右括号是否匹配
	public static boolean isComplete(String n) {
		ex3_3Calculate cal = new ex3_3Calculate();
		LinkStack st = new LinkStack();//初始化一个运算符栈
		String postfix = new String();//用于存放输出后的后缀表达式
		int countL=0;//两个整型变量用于计算左右括号的个数
		int countR=0;

		for(int i = 0; n != null && i<n.length(); i++) {
			char c = n.charAt(i); //从算数表达式中读取一个字符
			if(' ' != c) {		//字符c不为空格
				if(cal.isOpenParenthesis(c)) {
					//st.push(c);  //为左括号，压栈
					countL++;//计数器加1
				}
				else if(cal.isCloseParenthesis(c)) { //为闭括号
					countR++;//计数器加1
				}
			}
		}
		if(countL == countR) 
			return true;
		else
			return false;
	}
}
