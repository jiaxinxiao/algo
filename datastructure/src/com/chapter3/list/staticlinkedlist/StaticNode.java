package com.chapter3.list.staticlinkedlist;
/**
 * 静态链表结点
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class StaticNode {
	//数据域
	private String data;
	//游标（Cursor），为0时无指向
	private int cur;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getCur() {
		return cur;
	}
	public void setCur(int cur) {
		this.cur = cur;
	}
}
