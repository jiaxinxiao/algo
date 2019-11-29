package com.chapter3.tree;

import java.util.Scanner;
/**
 * 前序遍历初始化二叉树
 * 二叉树前序顺序为：AB#D##C##
 * @author jiaxinxiao
 */
public class CreateBiTree2 {
	public static void main(String[] args) {
		BiTree tree = new BiTree();
		createBiTree(tree);
		System.out.println("aaaaaa");
	}
	 static void createBiTree(BiTree tree){
		//递归终止条件
		if(tree == null){
			return;
		}
		//前序遍历输入结点
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入结点：");
		String data = sc.next();
		tree.data = data;
		if("#".equals(data)){
			tree.left = null;
			tree.right = null;
		}else{
			tree.left = new BiTree();
			tree.right = new BiTree();
		}
		createBiTree(tree.left);
		createBiTree(tree.right);
	}
}
//二叉树链式结构
class BiTree{
	String data;
	BiTree left;
	BiTree right;
}
