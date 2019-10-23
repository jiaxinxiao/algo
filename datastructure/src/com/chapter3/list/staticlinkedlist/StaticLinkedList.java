package com.chapter3.list.staticlinkedlist;
/**
 * 线性表的静态表存储结构
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class StaticLinkedList {
	private StaticNode[] staticArray = null;
	//链表大小
	private int size;
	//线性表长度（元素个数）
	private int count;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public StaticLinkedList(int size){
		this.staticArray = new StaticNode[size];
		this.size = size;
	}
	public StaticNode[] getStaticArray() {
		return staticArray;
	}
	public void setStaticArray(StaticNode[] staticArray) {
		this.staticArray = staticArray;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
}
