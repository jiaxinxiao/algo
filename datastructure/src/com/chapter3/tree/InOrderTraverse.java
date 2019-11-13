package com.chapter3.tree;
/**
 * 二叉树中序遍历
 * @author jiaxinxiao
 * @date 2019年11月13日
 */
public class InOrderTraverse {
	void inOrderTraverse(BiTree tree){
		if(tree == null){
			return;
		}
		inOrderTraverse(tree.left);
		System.out.println(tree.data);
		inOrderTraverse(tree.right);
	}
}
