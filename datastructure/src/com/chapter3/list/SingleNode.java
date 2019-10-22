package com.chapter3.list;
/**
 * 单链表结点pojo
 * @author jiaxinxiao
 * @date 2019年10月16日
 */
public class SingleNode {
	String data;//数据域
	SingleNode next;//指针域
	public SingleNode(){}
	public SingleNode(String data,SingleNode next){
		this.data = data;
		this.next = next;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public SingleNode getNext() {
		return next;
	}
	public void setNext(SingleNode next) {
		this.next = next;
	}
	
}
