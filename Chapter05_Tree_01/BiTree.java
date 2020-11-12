package Chapter05_Tree_01;
import Chapter03_01.LinkStack;
import Chapter03_01.LinkQueue;
import Chapter03_01.LinkQueue;
public class BiTree {
	private BiTreeNode root; //���ĸ��ڵ�
	//����һ�ÿ���
	public BiTree() {
		this.root = null;
	}
	//����һ����
	public BiTree(BiTreeNode root) {
		this.root = root;
	}
	//���ȸ��������и��������д���һ�ö��������㷨
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {
		
	}
	//�ɱ������������ȸ��������д���һ�ö��������㷨
	private static int index = 0; //���ڼ�¼preStr
	public BiTree(String preStr) {
		
	}
	//�ȸ������������ĵݹ��㷨
	public void preRootTraverse(BiTreeNode T) {
		if(T != null) {
			System.out.print(T.data); //���ʸ��ڵ�
			preRootTraverse(T.lchild); //�ȸ�����������
			preRootTraverse(T.rchild);//�ȸ�����������
		}
	}
	//�ȸ������������ķǵݹ��㷨
	public void preRootTraverse() throws Exception {
		BiTreeNode T = root;
		if(T != null) {
			LinkStack S = new LinkStack(); //����ջ
			S.push(T);//���ڵ���ջ
			while(!S.isEmpty()) {
				T = (BiTreeNode)S.pop();//�Ƴ�ջ����㣬��������ֵ
				System.out.print(T.data); //���ʽ��
				while(T != null) {
					if(T.lchild != null) {//��������
						System.out.print(T.lchild.data);//���ʽ��
					}
					if(T.rchild != null) {//�Һ��ӷǿ���ջ
						S.push(T.rchild); 
					}
					T = T.lchild;
				}
			}
		}
	}
	//�и������������ĵݹ��㷨
	public void inRootTraverse(BiTreeNode T) {
		if(T != null) {
			inRootTraverse(T.lchild); //
			System.out.print(T.data);
			inRootTraverse(T.rchild);
		}
	}
	//�и������������ķǵݹ��㷨
	public void inRootTraverse() throws Exception {
		BiTreeNode T = root; 
		if(T != null) {
			LinkStack S = new LinkStack(); //������ջ
			S.push(T); //���ڵ���ջ
			while(!S.isEmpty()) {
				while(S.peek() != null) { //��ջ���������ӽ�������ջ
					S.push(((BiTreeNode)S.peek()).lchild); 
				}
				S.pop(); //�ս����ջ
				if(!S.isEmpty()) {
					T = (BiTreeNode)S.pop(); //�Ƴ�ջ��ϵ�G������������ֵ
					System.out.print(T.data); //���ʽ��
					S.push(T.rchild);//�����Һ�����ջ
				}
			}
		}
	}
	//��������������ĵݹ��㷨
	public void postRootTraverse(BiTreeNode T) {
		if(T != null) {
			postRootTraverse(T.lchild);
			postRootTraverse(T.rchild);
			System.out.print(T.data);
		}
	}
	//��������������ķǵݹ��㷨
	public void postRootTraverse() throws Exception {
		BiTreeNode T = root;
		if(T != null) {
			LinkStack S = new LinkStack(); //������ջ
			S.push(T); //������ջ
			Boolean flag; //���ʱ��
			BiTreeNode p = null; //pָ��ձ����ʵĽ��
			while(!S.isEmpty()) { //ջ�ǿ�
				while(S.peek() != null) { //��ջ������������̽�ջ
					S.push(((BiTreeNode)S.peek()).lchild);
				}
				S.pop();//�ս����ջ
				while(!S.isEmpty()) {
					T = (BiTreeNode)S.peek(); //�鿴ջ��Ԫ��
					if(T.rchild == null || T.rchild == p) {
						System.out.print(T.data); //���ʽ��
						S.pop(); //�Ƴ�ջ��Ԫ��
						p = T; //pָ��ձ����ʵĽ��
						flag = true; //���÷��ʱ��
					}else {
						S.push(T.rchild); //�Һ��ӽ����ջ
						flag = false; //����δ�����ʱ��
					}
					if(!flag) {
						break;
					}
				}
			}
		}
	}
	//��α����������ķǵݹ��㷨(��������)
	public void levleTraverse() throws Exception {
		BiTreeNode T = root;
		if(T != null) {
			LinkQueue L = new LinkQueue(); //�������
			L.offer(T); //����������
			while(!L.isEmpty()) {
				T = (BiTreeNode)L.poll();
				System.out.print(T.data);//���ʽ��
				if(T.lchild != null) {//���ӷǿգ����
					L.offer(T.lchild);
				}
				if(T.rchild != null) { //�Һ��ӷǿգ����
					L.offer(T.rchild);
				}
			}
		}
	}
	public BiTreeNode getRoot() {
		return root;
	}
	public void setRoot(BiTreeNode root) {
		this.root = root;
	}
}
