package NationDay01;
import java.util.Scanner;
public class copy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int multiplier1 = in.nextInt();//�ϴ����
		int multiplier2 = in.nextInt();//��С����
		in.close();
		
		//������ĳ���ת��Ϊ�ַ���
		String m1 = multiplier1 + "";
		String m2 = multiplier2 + "";
		//������ĳ���ת��Ϊ�ַ�����
		char[] mul1 = m1.toCharArray();
		char[] mul2 = m2.toCharArray();
		//������ĳ���ת��Ϊ��������
		int[] x1 = new int[mul1.length];
		int[] x2 = new int[mul2.length];
		for(int i=0;i<x1.length;i++) {
			x1[i] = mul1[i] - '0';
		}
		for(int i=0;i<x2.length;i++) {
			x2[i] = mul2[i] - '0';
		}
		//�����鵹��
		reverseArray(x1);
		reverseArray(x2);
		int carry1 = 0;//������˵Ľ�λ
		int carry2 = 0;//������ӵĽ�λ
		int[] head = new int[x1.length+x2.length-1];//head�������ڴ洢���ս��
		
		for(int i=0;i<x2.length;i++) {
			int[] temp = new int[x1.length+x2.length-1];//temp�����������������˺�Ľ��
			for(int j=0;j<x1.length;j++) {
				temp[j] = (x1[j]*x2[i]+carry1)%10;//����ÿ����˵ĵ���
				carry1 = (x1[j]*x2[i]+carry1)/10;//�����λ
				if((j == x1.length-1) &&(i != 0))  {//�ж��Ƿ�Ϊ��һ�����
					move(temp, i);//�ȶԵ�����������ƶ�
					for(int k=0;k<head.length;k++) {
						int headtemp = head[k];//����head���鵱ǰλ����ֹ����һ��������
						head[k] = (head[k]+temp[k]+carry2)%10;//����ÿ����ӵĵ���
						carry2 = (headtemp+temp[k]+carry2)/10;//����ӷ��Ľ�λ
					}
					//��ʼ����λ
					carry1 = 0;
					carry2 = 0;
				}
				//��һ�����ʱ��ֱ�ӽ��������鸴�Ƶ�head������У����������Ӳ���
				else if((j==x1.length-1) && (i==0)) {
					for(int k=0;k<head.length;k++) {
						head[k] = temp[k];
					}
				}
			}
		}
		//����������
		for(int i=head.length-1;i>=0;i--) {
			System.out.print(head[i]);
		}
	}
	//�����鵹��ķ���
	public static void reverseArray(int Array[]) {
		int last = Array.length-1;
		for(int first=0;first<last;first++) {
			int temp = Array[first];
			Array[first] = Array[last];
			Array[last] = temp;
			last--;
		}
	}
	//�������ƶ��ķ���
	public static void move(int Array[],int n) {
		int[] temp = new int[n];//temp���鱣��ÿ���ƶ��󱻸��ǵ���
		for(int i=0;i<n;i++) {
			temp[i] = Array[Array.length-(i+1)];
		}
		int j=Array.length-n-1;
		//����������ƶ�
		for(int i=Array.length-1;i>(n-1);i--) {
			Array[i] = Array[j];
			j--;
		}
		//�������ǵ�����������ճ�����λ��
		for(int i=0;i<n;i++) {
			Array[i] = temp[n-(i+1)];
		}
	}

}