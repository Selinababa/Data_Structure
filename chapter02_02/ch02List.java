package chapter02_02;

public interface ch02List {
	//���
	//public void add(Object e);
	//β�巨��������
	public void create01(int n) throws Exception;
	//���뷽��
	public void insert(int i, Object x) throws Exception;
	//��ȡ������
	public int length();
	//���������
	public void display();
	//�ϲ�������
	public void merge(ch02Method h1, ch02Method h2, ch02Method m) throws Exception;
	//ɾ��
	public void delete();
	//����
	public void reverse();
	//get����
	public Object get(int i) throws Exception;
}
