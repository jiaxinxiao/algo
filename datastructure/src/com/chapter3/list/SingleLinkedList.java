package com.chapter3.list;
/**
 * 单链表pojo
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class SingleLinkedList {
	private SingleNode headNode;
	private int size;
	public SingleLinkedList(){}
	public SingleLinkedList(SingleNode headNode,int size){
		this.headNode = headNode;
		this.size = size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public SingleNode getHeadNode() {
		return headNode;
	}
	public void setHeadNode(SingleNode headNode) {
		this.headNode = headNode;
	}
}
