package com.chapter3.tree;
/**
 * 二叉树二叉线索存储结构定义
 * link 表示 左右孩子
 * thread 表示前驱后继
 * 
 * @author jiaxinxiao
 * @date 2019年11月14日
 */
public enum PointerTag {
	LINK(0),THREAD(1);
	int count;
	private PointerTag(int count){
		this.count = count;
	}
	public String toString(){
		return String.valueOf(this.count);
	}
}
