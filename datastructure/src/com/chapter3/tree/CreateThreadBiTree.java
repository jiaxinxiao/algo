package tree;
/**
 * 指针域为引用类型
 * 引用类型开辟空间为4个字节
 * 总共有n个结点，那么有2n个指针域
 * 有n-1个指针域是利用的，有n+1个指针域利用不上
 * 
 * 线索化的过程就是将n+1个指针利用上
 * 
 * 二叉树的线索化就是将一棵二叉树变成一个双向链表
 * @author jiaxinxiao
 * @date 2019-12-3
 */
public class CreateThreadBiTree {
	//计数器
	private int count = 0;
	private ThreadBiTree pre = null;//初始化前驱为null
	//二叉树数据域初始化（q前序）
	String[] strArrayPre = {"A","B","D","H","I","E","J","C","F","G"};
	//中序遍历顺序
//	String[] strArrayCen = {"H","D","I","B","J","E","A","F","C","G"};
	//后序遍历顺序
//	String[] strArrayNext = {"H","I","D","J","E","B","F","G","C","A"};
	//叶子结点初始化（字符串表示）
	static String str = "HIJFG";
	//测试
	public static void main(String[] args) {
		CreateThreadBiTree ctb = new CreateThreadBiTree();
		ThreadBiTree tree = new ThreadBiTree();
		//前序遍历初始化二叉树
//		ctb.createBiTreePre(tree);
//		System.out.println("前序遍历debug测试");
		//中序遍历初始化二叉树
//		ctb.createBiTreeCen(tree);
//		System.out.println("中序遍历debug测试");
		ctb.createBiTreeNext(tree);
		System.out.println("后序遍历debug测试");
		ctb.initThreadBiTree(tree);
		System.out.println("二叉树中序遍历线索化debug测试");
		ThreadBiTree treeHeadNode = new ThreadBiTree();
		ctb.addHeadNode(tree,treeHeadNode);
		System.out.println("双向循环列表debug测试");
		ctb.inOrderTraverse_Thr(treeHeadNode);
	}
	/**
	 * tree指向头结点，头结点左指针left指向根结点，头结点右指针right指向中序遍历最后一个结点
	 * 中序遍历二叉线索链表表示二叉树tree
	 * 
	 * 如果二叉树需经常遍历或查找结点时需要某种遍历序列中的前驱和后继
	 * 采用线索二叉链表的存储结构是不错的选择
	 * @param tree
	 */
	private void inOrderTraverse_Thr(ThreadBiTree tree){
		ThreadBiTree p = tree.left;//p指向根结点
		while(p != tree){//空树或遍历结束 p == tree
			while(p.ltag == PointerTag.CHILD){//当ltag == 0 代表遍历到中序序列的第一个结点
				p = p.left;
			}
			System.out.println(p.data);//打印结点数据
			while(p.rtag == PointerTag.THREAD && p.right != tree){
				p = p.right;
				System.out.println(p.data);
			}
			p = p.right;//p进右子树
		}
	}
	//线索二叉树添加头结点
	private void addHeadNode(ThreadBiTree tree,ThreadBiTree treeHeadNode){
		//头结点左指针指向根结点
		treeHeadNode.left = tree;
		//右指针指向中序遍历最有一个结点
		treeHeadNode.right = tree.right.right;
		//中序遍历第一个结点左指针指向头结点
		tree.left.left.left.left = treeHeadNode;
		//中序遍历最后一个结点右指针指向头结点
		tree.right.right.right = treeHeadNode;
	}
	//二叉树中序遍历线索化
	private void initThreadBiTree(ThreadBiTree tree){
		if(tree == null){
			return;
		}
		initThreadBiTree(tree.left);
		if(tree.left == null){
			tree.ltag = PointerTag.THREAD;
			tree.left = pre;
		}
		if(pre != null && pre.right == null){
			pre.rtag = PointerTag.THREAD;
			pre.right = tree;//前一个结点的后继指向当前结点
		}
		//pre指针每次记录上一个结点
		pre = tree;
		initThreadBiTree(tree.right);
	}
	//前序遍历初始化普通二叉树
	void createBiTreePre(ThreadBiTree tree){
		if(tree == null){
			return;
		}
		String data = strArrayPre[count++];
		nodeDeal(data, tree);
		//前序遍历先赋值
		tree.data = data;
		createBiTreePre(tree.left);
		createBiTreePre(tree.right);
	}
	//中序遍历初始化普通二叉树
	void createBiTreeCen(ThreadBiTree tree){
		if(tree == null){
			return;
		}
		String data = strArrayPre[count++];
		nodeDeal(data, tree);
		createBiTreeCen(tree.left);
		tree.data = data;
		createBiTreeCen(tree.right);
	}
	//后序遍历初始化普通二叉树
	void createBiTreeNext(ThreadBiTree tree){
		if(tree == null){
			return;
		}
		String data = strArrayPre[count++];
		nodeDeal(data,tree);
		createBiTreeNext(tree.left);
		createBiTreeNext(tree.right);
		tree.data = data;
	}
	void nodeDeal(String data,ThreadBiTree tree){
		if(str.contains(data)){
			//如果是叶子结点
			tree.left = null;
			tree.right = null;
		}else if(data.equals("E")){
			//E结点特殊处理
			tree.left = new ThreadBiTree();
			tree.right = null;
		}
		else{
			tree.left = new ThreadBiTree();
			tree.right = new ThreadBiTree();
		}
	}
}
//指针域类型：0代表指向左右孩子；1代表指向前驱或后继
enum PointerTag{
	CHILD(0),
	THREAD(1);
	private int value;
    private PointerTag(int value){
		this.value = value;
	}
    @Override
    public String toString(){
    	return String.valueOf(value);
    }
}
//线索二叉树数据结构
class ThreadBiTree{
	//数据域
	String data;
	//左指针
	ThreadBiTree left;
	//右指针
	ThreadBiTree right;
	//左类型指针
	PointerTag ltag;
	//右类型指针
	PointerTag rtag;
	public ThreadBiTree(){
		//默认构造结点都是指向子结点
		ltag = PointerTag.CHILD;
		rtag = PointerTag.CHILD;
	}
}
