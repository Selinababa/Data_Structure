package Chapter03_01;
import java.util.Scanner;
public class Example3_1 {
	private final int LEFT = 0; //记录类型为“左”的分隔符
	private final int RIGHT = 1; //记录类型为“右”的分隔符
	private final int OTHER = 2; //记录其他字符
	
	//判断分隔符的类型，有3种：“左”，“右”，“非法”
	public int verifyFlag(String str) {
		if("(".equals(str)||"{".equals(str)||"[".equals(str)||"/*".equals(str))
			return LEFT;
		else if(")".equals(str)||"}".equals(str)||"]".equals(str)||"*/".equals(str))
			return RIGHT;
		else
			return OTHER;
	}
	//检验左分隔符str1和右分隔符是否匹配
	public boolean matches(String str1, String str2) {
		if(("(".equals(str1)&&")".equals(str2))||("{".equals(str1)&&"}".equals(str2))||("[".equals(str1)&&"]".equals(str2))||("/*".equals(str1)&&"*/".equals(str2)))
			return true;
		else
			return false;
	}
	//判断输入的语句是否合法
	private boolean isLegal(String str) throws Exception{
		if(!"".equals(str) && str != null) {
			SqStack S = new SqStack(100); //新建最大存储空间为100的顺序栈
			int length = str.length();
			for(int i=0; i<length; i++) {
				char c = str.charAt(i);//指定索引处的char值
				String t = String.valueOf(c); //转化成字符串型
				if(i != length) {
					if(('/' == c && '*' == str.charAt(i+1)) || ('*' == c && '/' == str.charAt(i+1))) {//分隔符类型为/*或*/
						t= t.concat(String.valueOf(str.charAt(i+1)));//与后一个字符相连
						++i;
					}
				}
				if(LEFT == verifyFlag(t)) {
					S.push(t);//将t压入栈
				}
				else if(RIGHT == verifyFlag(t)) {
					if(S.isEmpty() || !matches(S.pop().toString(),t)) {
						throw new Exception("错误：Java语句不合法！");
					}
				}
			}
			if(!S.isEmpty())
				throw new Exception("错误：Java语句不合法！");
			return true;
		}
		else
			throw new Exception("错误：Java语句为空！");
	}
	//主函数
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		Example3_1 e = new Example3_1();
		System.out.println("请输入分Java语句");
		if(e.isLegal(sc.nextLine()))
			System.out.println("Java语句合法！");
		else
			System.out.println("错误：Java语句不合法！");
	}
}
