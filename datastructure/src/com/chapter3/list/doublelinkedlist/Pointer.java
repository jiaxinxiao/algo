package com.chapter3.list.doublelinkedlist;
/**
 * 指针枚举
 * @author jiaxinxiao
 * @date 2019年10月26日
 */
public enum Pointer {
	prior("prior"),
	next("next");
	private String value;
	private Pointer(String value){
		this.value = value;
	}
	public String toString(){
		return this.value.toString();
	}
}
