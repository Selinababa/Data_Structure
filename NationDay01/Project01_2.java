package NationDay01;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//�������
public class Project01_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//����������������������������
		System.out.println("�������һ����:");
		char[] nums1 = sc.next().toCharArray();
		System.out.println("������ڶ�����:");
		char[] nums2 = sc.next().toCharArray();
		
		//����������ת��Ϊ��������
		ArrayList<Integer> num1 = new ArrayList<Integer>();
		toIntArray(nums1, num1);
		ArrayList<Integer> num2 = new ArrayList<Integer>();
		toIntArray(nums2, num2);
		
		//�жϴ�С,ȷ����һ�����ǽϴ����
		if(num1.size() < num2.size()){
			ArrayList<Integer> list = null;
			list = num1;
			num1 = num2;
			num2 = list;
		}
		
		ArrayList<Integer> answer = new ArrayList<Integer>();//����һ���������ڼ�¼���
		int n = 0; //��¼��λ
		for (int i = 0; i < num2.size(); i++) {				//˫��ѭ��,��λ���
			for (int j = 0; j < num1.size(); j++) {
				if(i + j < answer.size()){ //�����������Ѿ���ֵ�ˣ������������ԭ����ֵ
					n = num1.get(j) * num2.get(i) + n + answer.get(i+j);
					answer.set(i + j, n % 10);
				}else { //��n����10�����������������
					n = num1.get(j) * num2.get(i) + n;					
					answer.add(n % 10);
				}
				n = n / 10;
			}
			if(n != 0){	//ÿ���׶εĽ�λ
				answer.add(n);
				n = 0;
			}
		}
		if(n != 0){		//ȫ������Ľ�λ
			answer.add(n);
		}
		Collections.reverse(answer);//�������ת
		System.out.println("���֮����Ϊ:"+answer.toString().replace(" ", "").replace(",", ""));
	}
	//ת��Ϊ�������ϲ���ת,�������  
	private static void toIntArray(char[] nums,ArrayList<Integer> list){
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i] - '0');
		}
		Collections.reverse(list);
	}	
}
