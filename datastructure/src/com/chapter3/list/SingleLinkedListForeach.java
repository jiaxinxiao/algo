package com.chapter3.list;
/**
 * 单链表遍历（获取第i个结点的元素）
 * 最坏情况时间复杂度为O(n)
 * 单链表的结构中没有定义表长
 * 不能用for循环
 * 工作指针后移  为核心思想
 * @author jiaxinxiao
 * @date 2019年10月16日
 */
public class SingleLinkedListForeach {
	//返回一个链表的头结点
	public static SingleNode getHeadNode(){
		SingleNode headNode = new SingleNode(null, new SingleNode("1", new SingleNode("2", new SingleNode("3", new SingleNode("4", new SingleNode("5", null))))));
		return headNode;
	}
	//从头结点遍历到第i个结点，取出数据域中的数据
	public static String getElem(SingleNode headNode,int i){
		int j = 1;//计数器
		SingleNode p = headNode.next; //p指针指向链表的第一个结点
		while(p != null && j<i){
			p = p.next;
			j++;
		}
		if(p == null){
			return null;
		}
		return p.data;
	}
	//测试
	public static void main(String[] args) {
		System.out.println(getElem(getHeadNode(),5));
	}
}
