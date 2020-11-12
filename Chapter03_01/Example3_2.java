package Chapter03_01;

public class Example3_2 {
	//求两个大数的和，加数和被加数以字符串的形式输入（允许大数中出现空格），计算的结果也以字符串的形式返回
	public String add(String a , String b) throws Exception{
		LinkStack sum = new LinkStack(); //大数的和
		LinkStack sA = numSplit(a); //加数字符串以单个字符的形式放入栈中
		LinkStack sB = numSplit(b); //被加数字符串以单个字符的形式放入栈中
		int partialSum; //对于两个位的求和
		boolean isCarry = false; //进位标示
		while(!sA.isEmpty() && sB.isEmpty()) { //加数和被加数栈同时非空
			partialSum = (Integer)sA.pop() + (Integer)sB.pop();
			//对于两个位的求和，并在栈中去除加数和被加数中的该位
			if(isCarry) {//低位进位
				partialSum++; //进位加到此位上
				isCarry = false; //重置进位标识
			}
			if(partialSum >= 10) { //需要进位
				partialSum -= 10; 
				sum.push(partialSum);
				isCarry = true; //标识进位
			}else { //位和不需要进位
				sum.push(partialSum); //和放入栈中
			}
		}
		LinkStack temp = !sA.isEmpty() ? sA : sB; //引用指向加数和被加数中非空栈
		while(!temp.isEmpty()) {
			if(isCarry) { //最后一次执行加法运算中需要进位
				int t = (Integer) temp.pop();//取出加数或被加数没有参加的位
				++t; //进位加到此位上
				if(t >= 10) { //需要进位
					t -= 10;
					sum.push(t);
				}else {
					sum.push(t);
					isCarry = false; //重置进位标识
				}
			}else
				//最后一次执行加法运算不需要进位
				sum.push(temp.pop()); //把加数或被加数中非空的值放入和中
		}
		if(isCarry) { //最高位需要进位
			sum.push(1);//进位放入栈中
		}
		String str = new String();
		while(!sum.isEmpty())
			//把栈中元素转化成字符串
			str = str.concat(sum.pop().toString());
		return str;
	}
	//字符串以单个字符的行书放入栈中，并取出字符串中的空格，返回以单个字符为元素的栈
	public LinkStack numSplit(String str) throws Exception{
		LinkStack s = new LinkStack();
		for(int i = 0; i<str.length(); i++) {
			char c = str.charAt(i); //指定索引处的char值
			if(' ' == c) { //去除空格
				continue;
			}else if('0' <= c && '9' >= c) {//数字放入栈中
				s.push(Integer.valueOf(String.valueOf(c)));
			}else {
				throw new Exception("错误：输入了非法字符！");
			}
		}
		return s;
	}
	public static void main(String[] args) throws Exception{
		Example3_2 e = new Example3_2();
		System.out.println("两个大数的和为："+ e.add("18 425 543 389 943 209 752 345 473",
				"2 456 234 678 634"));
		//输出运算结果
	}
}
