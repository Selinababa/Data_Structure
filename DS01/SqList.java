package DS01;

public class SqList implements Ilist{
	
	private Object[] listElem; //线性表存储空间
	private int curLen; //带你星标的当前长度
	
	//顺序表类的构造函数，构造一个存储空间容量为maxSize的线性表
	public SqList(int maxSize) {
		curLen = 0; //置顺序表的当前长度为0
		listElem = new Object[maxSize]; //为顺序表分配msxSize个存储单元
	}
	//置空
	public void clear() {
		curLen = 0;
	}
	//判空
	public boolean isEmpty() {
		return curLen == 0;
	}
	//求线性表中数据元素的个数并返回其值
	public int length() {
		return curLen;
	}
	//读取到线性表中的第i个数据元素并由函数返回其值，其中i的取值范围为：0<=i<=length()-1，
	//若i值不在此范围则抛出异常
	public Object get(int i) throws Exception{
		if(i<0 || i>curLen-1)   //i小于0或大于表长-1
			throw new Exception("第" +i+ "个元素不存在");
		return listElem[i]; //返回顺序表中第i个元素
	}
	//在线性表的第i个数据元素之前插入一个值为x的数据元素
	public void insert(int i, Object x) throws Exception {
		if(curLen == listElem.length) //判断顺序表是否已满
			throw new Exception("顺序表已满");
		if(i<0 || i>curLen) //i不合法
			throw new Exception("插入位置不合法");
		for(int j = curLen; j>i; j--) {
			listElem[j] = listElem[j-1]; //插入位置及其之后的所有数据元素后移一位
		}
		listElem[i] = x; //插入x
		curLen++; //表长加1
	}
	//删除并返回线性表中第i个数据元素
	public void remove(int i) throws Exception{
		if(i<0 || i>curLen-1) //i不合法
			throw new Exception("删除位置不合法");
		for(int j = i; j<curLen - 1; j++)
			listElem[j] = listElem[j+1]; //被删除元素之后的所有数据元素左移一个存储位置
		curLen--; //表长减一
	}
	//返回线性表中首次出现非指定的数据元素的为序号，若线性表中不包含此数据元素，则返回-1
	public int indexOf(Object x) {
		int j = 0; //j指示顺序表中待比较的数据元素，其初始值指示顺序表中第0个升级元素
		while(j<curLen && !listElem[j].equals(x)) //依次比较
			j++;
		if(j<curLen) //判断j的位置是否位于顺序表中
			return j; //返回值为x的数据元素在顺序表中的位置
		else
			return -1; //值为x的数据元素在顺序表中不存在
	}
	//输出线性表中的数据元素
	public void display() {
		for(int j = 0; j<curLen; j++) {
			System.out.print(listElem[j]+" ");
		}
		System.out.println();
	}
}
