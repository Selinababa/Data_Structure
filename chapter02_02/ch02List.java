package chapter02_02;

public interface ch02List {
	//添加
	//public void add(Object e);
	//尾插法创建链表
	public void create01(int n) throws Exception;
	//插入方法
	public void insert(int i, Object x) throws Exception;
	//获取链表长度
	public int length();
	//输出单链表
	public void display();
	//合并单链表
	public void merge(ch02Method h1, ch02Method h2, ch02Method m) throws Exception;
	//删除
	public void delete();
	//置逆
	public void reverse();
	//get函数
	public Object get(int i) throws Exception;
}
