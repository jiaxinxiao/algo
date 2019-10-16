package com.chapter3.list;
/**
 * 链表结点
 * @author jiaxinxiao
 * @date 2019年10月16日
 */
public class Node {
	String data;//数据域
	Node next;//指针域
	public Node(String data,Node next){
		this.data = data;
		this.next = next;
	}
}
