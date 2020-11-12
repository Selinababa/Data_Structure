package Chapter03_01;
import java.util.Scanner;
public class Hanoi {
	
	private static int c = 0;//ȫ�ֱ������԰ᶯ����
	
	//������x�ϰ�ֱ���ɴ�С�����϶��µı��Ϊ1��n��n��Բ�̰������ƶ�������z��
	//y������������
	public  void hanoi(int n, char x, char y, char z) throws Exception{
		
		if(n == 1) {
			move(x,1,z);//�����Ϊ1��Բ�̴�x�Ƶ�z
			
		}else {
			hanoi(n-1, x, z, y); //��x�ϱ��Ϊ1��n-1��Բ���ƶ���y��z����������
			move(x, n, z); //�����Ϊn��Բ�̴�x�ƶ���z
			hanoi(n-1, y, x, z); //��y�ϱ��Ϊ1��n-1��Բ���ƶ���z��x����������
		}
	}
	//�ƶ������������Ϊn��Բ�̴�x�ƶ���z
	public void move(char x, int n, char z) {
		System.out.println("��" + ++c + "���ƶ�" +n+ "��Բ��" +x+ "->" +z);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Hanoi h = new Hanoi();
		int n = -1;//nΪԲ�̵ĸ���
		char x = 0;//�½������ַ�����������������
		char y = 0;
		char z = 0;
		while(n != 0) {
			System.out.println("������Բ�̵ĸ���n(����0ʱ��������):");
			n = sc.nextInt();
			c = 0;
			h.hanoi(n, 'x', 'y', 'z');//���ú����ƶ�Բ��
		}
	}
}
