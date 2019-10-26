package com.chapter3.list.doublelinkedlist;
/**
 * 线性表的双向链表存储结构
 * @author jiaxinxiao
 * @date 2019年10月25日
 */
public class DulNode {
	//数据域
	private String data;
	//直接前驱指针
	private DulNode prior;
	//直接后驱指针
	private DulNode next;
	public DulNode(){
	}
	public DulNode(String data){
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public DulNode getPrior() {
		return prior;
	}
	public void setPrior(DulNode prior) {
		this.prior = prior;
	}
	public DulNode getNext() {
		return next;
	}
	public void setNext(DulNode next) {
		this.next = next;
	}
}
