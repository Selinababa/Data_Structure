package DS01;//�ڶ��£��������ʵ��
import java.util.Scanner;
public class MainOfLinkList01 {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		
		LinkList01 li = new LinkList01();	//����һ���յĵ�����
		
		//һ.��������ָ�������ı�Ԫ��ֵ������ͷ�巨����һ��������������������и�Ԫ�ص�ֵ��
		//ͬʱ�۲�������������������Ƿ�һ��
		System.out.print("Please input the length of the LinkList:");
		int length = input.nextInt();//����һ�����������ڸ��������Ԫ�ظ���
		System.out.println("Plese input "+length+" characters:");
		li.create1(length);//���ú���create1����ͷ�巨����������
		li.display();//����������е����н��
		
		//��.�ڵ�����ĵ�ins_i��Ԫ��֮ǰ����һ��ֵΪins����Ԫ�أ�����������ĵ������и�Ԫ�ص�ֵ
		System.out.print("Where do you want to insert the new number(0<ins_i<"+length+"):");
		int ins_i = input.nextInt()-1;  //�����û�������ǲ����λ�ã����±�Ӧ�ñ�����ֵС1
		System.out.print("Please input the character you want to insert:");
		Object ins = input.next();
		li.insert(ins_i, ins); //������������뵽��������
		li.display(); //��������ĵ�����
		
		//��.ɾ���������е�i��Ԫ�أ������ɾ����ĵ������и�Ԫ�ص�ֵ
		System.out.print("Please input the tag of the character you want to delete:");
		int del = input.nextInt()-1; //����һ���������ڹ涨��Ҫɾ����Ԫ��
		li.remove(del);
		li.display();
		
		//��.�ڵ������в��ҵ�i��Ԫ�أ�������ҳɹ����������Ԫ�ص�ֵ�����������Ԫ�ز�����
		System.out.print("Please input the tag of the character you want to search:");
		int search = input.nextInt()-1;
		li.get(search);
		
		//��.�ڵ������в���ֵΪy��Ԫ�أ�������ҳɹ����������Ԫ�ص�λ��ţ�0~n-1�������������Ԫ�ز�����
		System.out.print("Please input the character you want to search:");
		Object ind = input.next();
		li.indexOf(ind);
		if(li.indexOf(ind)!=-1) {
			System.out.println("The tag of the element you want to search is "+li.indexOf(ind));
		}else {
			System.out.println("The element you're searching doesn't exist.");
		}
		
		//��.ɾ���ظ�Ԫ��
		System.out.println("The list before deletion are:");
		li.display();
		li.delete_same(li);
		System.out.println("The list after deletion are:");
		li.display();
		
		//��.��������͵����������������и�Ԫ�ص�ֵ
		System.out.println("The former list:");
		li.display();
		System.out.println("The list after reverseing:");
		li.reverse();
		li.display();
	}
}
