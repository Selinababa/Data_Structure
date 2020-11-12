package Chapter05_Tree_01;

public class BiTreeNode {
	public Object data;  //����������
	public BiTreeNode lchild, rchild; //���Һ�����
	//����һ���ս��
	public BiTreeNode() {
		this(null);
	}
	//����һ�����Һ�����Ϊ�յĶ�����
	public BiTreeNode(Object data) {
		this(data, null, null);
	}
	//����һ������������Һ����򶼲�Ϊ�յĶ�����
	public BiTreeNode(Object data, BiTreeNode lchild, BiTreeNode rchild) {
		this.data = data;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
