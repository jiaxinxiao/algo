package com.chapter3.tree;
/**
 * 二叉树线索化
 * 中序遍历
 * @author jiaxinxiao
 * @date 2019年11月15日
 */
public class BiThrTreeInit {
	BiThrTree pre;//全局变量，始终指向刚刚访问过的结点
	
	//中序遍历实例化二叉线索树
	void inThreading(BiThrTree p){
		if(p != null){
			//递归左子树线索化
			inThreading(p.lchild);
			//没有左孩子
			if(p.lchild == null){
				//前驱线索
				p.ltag = PointerTag.THREAD;
				//左孩子指针指向前驱
				p.lchild = pre;
			}
			if(pre != null && pre.rchild == null){
				//后继线索
				pre.rtag = PointerTag.THREAD;
				//前驱右孩子指针指向后继（当前结点P）
				pre.rchild = p;
			}
			//保持pre指向p的前驱
			pre = p;
			inThreading(p.rchild);
		}
	}
}
