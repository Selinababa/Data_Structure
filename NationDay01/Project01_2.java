package NationDay01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//大数相乘
public class Project01_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//输入两个乘数并存入两个数组中
		System.out.println("请输入第一个数:");
		char[] nums1 = sc.next().toCharArray();
		System.out.println("请输入第二个数:");
		char[] nums2 = sc.next().toCharArray();
		
		//将两个数组转化为整型数组
		ArrayList<Integer> num1 = new ArrayList<Integer>();
		toIntArray(nums1, num1);
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		toIntArray(nums2, num2);
		
		//判断大小,确保第一个数是较大的数
		if(num1.size() < num2.size()){
			ArrayList<Integer> list = null;
			list = num1;
			num1 = num2;
			num2 = list;
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();//定义一个数组用于记录结果
		int n = 0; //记录进位
		for (int i = 0; i < num2.size(); i++) {				//双重循环,错位相加
			for (int j = 0; j < num1.size(); j++) {
				if(i + j < answer.size()){ //结果数组如果已经有值了，则需加上数组原来的值
					n = num1.get(j) * num2.get(i) + n + answer.get(i+j);
					answer.set(i + j, n % 10);
				}else { //将n除以10的余数赋给结果数组
					n = num1.get(j) * num2.get(i) + n;					
					answer.add(n % 10);
				}
				n = n / 10;
			}
			if(n != 0){	//每个阶段的进位
				answer.add(n);
				n = 0;
			}
		}
		if(n != 0){		//全部算完的进位
			answer.add(n);
		}
		Collections.reverse(answer);//将结果反转
		System.out.println("相乘之后结果为:"+answer.toString().replace(" ", "").replace(",", ""));
	}
	//转换为整数集合并反转,方便操作  
	private static void toIntArray(char[] nums,ArrayList<Integer> list){
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i] - '0');
		}
		Collections.reverse(list);
	}	
}
