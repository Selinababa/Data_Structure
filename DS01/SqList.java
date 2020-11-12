package DS01;

public class SqList implements Ilist{
	
	private Object[] listElem; //���Ա�洢�ռ�
	private int curLen; //�����Ǳ�ĵ�ǰ����
	
	//˳�����Ĺ��캯��������һ���洢�ռ�����ΪmaxSize�����Ա�
	public SqList(int maxSize) {
		curLen = 0; //��˳���ĵ�ǰ����Ϊ0
		listElem = new Object[maxSize]; //Ϊ˳������msxSize���洢��Ԫ
	}
	//�ÿ�
	public void clear() {
		curLen = 0;
	}
	//�п�
	public boolean isEmpty() {
		return curLen == 0;
	}
	//�����Ա�������Ԫ�صĸ�����������ֵ
	public int length() {
		return curLen;
	}
	//��ȡ�����Ա��еĵ�i������Ԫ�ز��ɺ���������ֵ������i��ȡֵ��ΧΪ��0<=i<=length()-1��
	//��iֵ���ڴ˷�Χ���׳��쳣
	public Object get(int i) throws Exception{
		if(i<0 || i>curLen-1)   //iС��0����ڱ�-1
			throw new Exception("��" +i+ "��Ԫ�ز�����");
		return listElem[i]; //����˳����е�i��Ԫ��
	}
	//�����Ա�ĵ�i������Ԫ��֮ǰ����һ��ֵΪx������Ԫ��
	public void insert(int i, Object x) throws Exception {
		if(curLen == listElem.length) //�ж�˳����Ƿ�����
			throw new Exception("˳�������");
		if(i<0 || i>curLen) //i���Ϸ�
			throw new Exception("����λ�ò��Ϸ�");
		for(int j = curLen; j>i; j--) {
			listElem[j] = listElem[j-1]; //����λ�ü���֮�����������Ԫ�غ���һλ
		}
		listElem[i] = x; //����x
		curLen++; //����1
	}
	//ɾ�����������Ա��е�i������Ԫ��
	public void remove(int i) throws Exception{
		if(i<0 || i>curLen-1) //i���Ϸ�
			throw new Exception("ɾ��λ�ò��Ϸ�");
		for(int j = i; j<curLen - 1; j++)
			listElem[j] = listElem[j+1]; //��ɾ��Ԫ��֮�����������Ԫ������һ���洢λ��
		curLen--; //����һ
	}
	//�������Ա����״γ��ַ�ָ��������Ԫ�ص�Ϊ��ţ������Ա��в�����������Ԫ�أ��򷵻�-1
	public int indexOf(Object x) {
		int j = 0; //jָʾ˳����д��Ƚϵ�����Ԫ�أ����ʼֵָʾ˳����е�0������Ԫ��
		while(j<curLen && !listElem[j].equals(x)) //���αȽ�
			j++;
		if(j<curLen) //�ж�j��λ���Ƿ�λ��˳�����
			return j; //����ֵΪx������Ԫ����˳����е�λ��
		else
			return -1; //ֵΪx������Ԫ����˳����в�����
	}
	//������Ա��е�����Ԫ��
	public void display() {
		for(int j = 0; j<curLen; j++) {
			System.out.print(listElem[j]+" ");
		}
		System.out.println();
	}
}
