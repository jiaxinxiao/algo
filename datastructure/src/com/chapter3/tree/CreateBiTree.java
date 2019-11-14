package com.chapter3.tree;
/**
 * 二叉树的建立
 * 二叉树前序顺序为：AB#D##C##
 * 前序遍历算法中打印结点改为生成结点
 * @author jiaxinxiao
 * @date 2019年11月14日
 */
public class CreateBiTree {
	//计数器
	static int i = -1;
	//前序遍历
	static String str = "AB#D##C##";
	//初始化二叉树
	public static void createBiTree(BiTree tree){
		i++;
		//遍历结束直接返回
		if(i == str.toCharArray().length){
			return;
		}
		char c = str.charAt(i);
		if(c == '#'){
			tree = null;
		}else{
			tree.data = String.valueOf(c);//生成结点
			tree.left = new BiTree();
			tree.right = new BiTree();
			createBiTree(tree.left);
			createBiTree(tree.right);
		}
	}
	//测试
	public static void main(String[] args) {
		BiTree tree = new BiTree();
		createBiTree(tree);
	}
}
