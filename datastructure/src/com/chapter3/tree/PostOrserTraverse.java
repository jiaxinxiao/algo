package com.chapter3.tree;
/**
 * 二叉树后序遍历
 * @author jiaxinxiao
 * @date 2019年11月13日
 */
public class PostOrserTraverse {
	void postOrserTraverse(BiTree tree){
		if(tree == null){
			return;
		}
		postOrserTraverse(tree.left);
		postOrserTraverse(tree.right);
		System.out.println(tree.data);
	}
}
