package Chapter03_01;
import Chapter03_01.LinkQueue;
import DS01.SqList;

public class RingOfSim { //��1~n��n����Ȼ�����гɻ��Σ�ʹ��ÿ��������֮��Ϊ�������Ӷ�����һ��������
	
	private static int n;//�½�һ��ȫ�ֱ���n��Ϊ����������Ȼ���ĸ���
	public static void main(String[] args) throws Exception {
		SqList L = new SqList(n);  //˳������ڴ�������� (SqList��Ĺ��캯�����Σ�����Ϊһ�����ͱ���������)
		LinkQueue Q = new LinkQueue();//�������ڴ�Ż�δ���뵽�������е���Ȼ��
		
		//��ʼ��˳���L����1���뵽˳���L��
		L.insert(0,1);
		//��ʼ������Q����2~n����Ȼ��ȫ�����뵽Q������
		for(int i = 2; i<n; i++) {
			Q.offer(i);
		}
	}
}
