package com.chapter3.tree;
/**
 * 二叉树前序遍历
 * @author jiaxinxiao
 * @date 2019年11月13日
 */
public class PreOrderTraverse {
	void preOrderTraverse(BiTree tree){
		if(tree == null){
			return;
		}
		System.out.println(tree.data);
		preOrderTraverse(tree.left);
		preOrderTraverse(tree.right);
	}
}
