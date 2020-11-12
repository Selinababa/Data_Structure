package DS01;//第二章：单链表的实现
import java.util.Scanner;
public class MainOfLinkList01 {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		
		LinkList01 li = new LinkList01();	//创建一个空的单链表
		
		//一.根据输入指定个数的表元素值，采用头插法建立一个单链表，并输出单链表中各元素的值，
		//同时观察输入内容与输出内容是否一致
		System.out.print("Please input the length of the LinkList:");
		int length = input.nextInt();//定义一个变量，用于更改输入的元素个数
		System.out.println("Plese input "+length+" characters:");
		li.create1(length);//调用函数create1，用头插法创建单链表
		li.display();//输出单链表中的所有结点
		
		//二.在单链表的第ins_i个元素之前插入一个值为ins的新元素，并输出插入后的单链表中各元素的值
		System.out.print("Where do you want to insert the new number(0<ins_i<"+length+"):");
		int ins_i = input.nextInt()-1;  //由于用户输入的是插入的位置，其下标应该比输入值小1
		System.out.print("Please input the character you want to insert:");
		Object ins = input.next();
		li.insert(ins_i, ins); //将输入的数插入到单链表中
		li.display(); //输出插入后的单链表
		
		//三.删除单链表中第i个元素，并输出删除后的单链表中各元素的值
		System.out.print("Please input the tag of the character you want to delete:");
		int del = input.nextInt()-1; //定义一个变量由于规定需要删除的元素
		li.remove(del);
		li.display();
		
		//四.在单链表中查找第i个元素，如果查找成功，则输出该元素的值；否则，输出该元素不存在
		System.out.print("Please input the tag of the character you want to search:");
		int search = input.nextInt()-1;
		li.get(search);
		
		//五.在单链表中查找值为y的元素，如果查找成功，则输出该元素的位序号（0~n-1）；否则，输出该元素不存在
		System.out.print("Please input the character you want to search:");
		Object ind = input.next();
		li.indexOf(ind);
		if(li.indexOf(ind)!=-1) {
			System.out.println("The tag of the element you want to search is "+li.indexOf(ind));
		}else {
			System.out.println("The element you're searching doesn't exist.");
		}
		
		//六.删除重复元素
		System.out.println("The list before deletion are:");
		li.display();
		li.delete_same(li);
		System.out.println("The list after deletion are:");
		li.display();
		
		//七.将单链表就地置逆后输出单链表中各元素的值
		System.out.println("The former list:");
		li.display();
		System.out.println("The list after reverseing:");
		li.reverse();
		li.display();
	}
}
