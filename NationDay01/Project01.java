package NationDay01;
import java.util.*;
import java.math.*;

public class Project01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//�������Ĵ洢
		int a[] = new int [10];//�½�һ���������ڴ�ŵ�һ������
		int b[] = new int [10];//���ڴ�ŵڶ�������
		System.out.println("����������������λ����");
		int l1 = input.nextInt();
		int l2 = input.nextInt();
		System.out.println("�������һ��������10λ�ĳ�����");
		for(int i=l1-1 ; i>=0; i--) {//ѭ�������һ����������Ž�����a
			a[i] = input.nextInt();
		}
		System.out.println("������ڶ���������10λ�ĳ�����");
		for(int j=l2-1 ; j>=0; j--) {//ѭ������ڶ�����������Ž�����b
			b[j] = input.nextInt();
		}
		//������������ˣ�
		for(int x=0; x<b.length; x++) {//��һ��ѭ���ǵڶ�������
			for(int y=0; y<a.length; y++) {//�ڶ���ѭ���ǵ�һ������
				int temp01=0;//����temp01���ڴ�ų˷���λ����
				int temp02=0;//����temp02���ڴ�żӷ���λ������
				int c[] = new int[11];//����һ���������ڴ�Ž��
				int re = b[x] * a[y];//re������ʱ���������˵Ľ��
				c[y] = c[y] + (re + temp01)%10;
				temp01 = re / 10;
				temp02 = c[y] / 10;
			}//�ڶ���ѭ������ʱ������˵ڶ����������һ����������λ���ĳ˷�����
		}//��һ��ѭ������ʱ�������������������˺����
	}
	
}
