package Chapter03_01;
import java.util.*;
public class ex3_3Calculate {
	
	//将算数表达式转换为后缀表达式的函数，结果以字符串的形式返回
	public String convertToPostfix(String expression) throws Exception{
		LinkStack st = new LinkStack();//初始化一个运算符栈
		String postfix = new String();//用于存放输出后的后缀表达式
		
		for(int i = 0; expression != null && i<expression.length(); i++) {
			char c = expression.charAt(i);//从算数表达式中读取一个字符
			if(' ' != c) {		//字符c不为空格
				if(isOpenParenthesis(c)) {
					st.push(c);  //为开括号，压栈
				}
				else if(isCloseParenthesis(c)) { //为闭括号
					char ac = (Character) st.pop(); //弹出栈顶元素
					while(!isOpenParenthesis(ac)) { //一直到为开括号为止
						postfix = postfix.concat(String.valueOf(ac));
						//串联到后缀表达式的结尾
						ac = (Character) st.pop();
					}
				}
				else if(isOperator(c)) {//为运算符
					if(!st.isEmpty()) {//栈非空，取出栈顶优先级高的运算符送往后缀表达式
						Object ac = (Object) st.pop();
						while(ac != null && priority(((Character) ac).charValue()) >= priority(c)) {
							postfix = postfix.concat(String.valueOf(ac));
							ac = (Character) st.pop();
						}
						if(ac != null) {//若最后一次取出的优先级低的操作符，重新压栈
							st.push(ac);
						}
					}
					st.push(c);//压栈
				}
				else { //为操作数，串联到后缀表达式的结尾
					postfix = postfix.concat(String.valueOf(c));
				}
			}
		}
		while(!st.isEmpty()) //栈中剩余的所有操作符串联到后缀表达式的结尾
			postfix = postfix.concat(String.valueOf(st.pop()));
		return postfix;
	}
	
	//对后缀表达式进行求值计算的函数
	public double numberCalculate(String postfix) throws Exception{
		LinkStack st = new LinkStack();
		for(int i = 0; postfix !=null && i<postfix.length(); i++) {
			char c = postfix.charAt(i);//从后缀表达式中读取一个字符
			if(isOperator(c)) {//当为操作符时
				//取出两个操作数
				double d2 = Double.valueOf(st.pop().toString());
				double d1 = Double.valueOf(st.pop().toString());
				double d3 = 0;
				if('+' == c) {//加法运算
					d3 = d1 + d2;
				}else if('-' == c) { //减法运算
					d3 = d1 - d2;
				}else if('*' == c) { //乘法运算
					d3 = d1 * d2;
				}else if('/' == c) { //除法运算
					d3 = d1 / d2;
				}else if('^' == c) {//幂运算
					d3 = Math.pow(d1, d2);
				}else if('%' == c) { //求余运算
					d3 = d1 % d2;
				}
				st.push(d3);//当为操作数
			}else {
				st.push(c);
			}
		}
		return(Double)st.pop();//返回运算结果
	}
	
	//判断字符串是否为运算符
	public boolean isOperator(char c) {
		if('+' == c || '-' == c || '*' == c || '/' == c || '^' == c || '%' == c) {
			return true;
		}else {
			return false;
		}
	}
	
	//判断字符串是否为开括号
	public boolean isOpenParenthesis(char c) {
		return '(' ==c;
	}
	
	//判断字符串是否为闭括号
	public boolean isCloseParenthesis(char c) {
		return ')' == c;
	}
	
	//判断运算法的优先级
	public int priority(char c) {
		if(c == '^') { //为幂运算符
			return 3;
		}
		if(c == '*' || c == '/' || c == '%') {//为乘法，除法，取模运算
			return 2;
		}
		else if(c == '+' || c == '-') { //为加，减运算
			return 1;
		}else {   //其他
			return 0;
		}	
	}
	
	public static void main(String[] args) throws Exception{
		ex3_3Calculate p = new ex3_3Calculate();
		String postfix = p.convertToPostfix("(1+2) * (5-2) / 2 ^ 2 + 5%3");//转为后缀表达式
		System.out.println("表达式结果为："+p.numberCalculate(postfix));//对后缀表达式求值后，输出
	}
	
}
