package com.chapter3.list.staticlinkedlist;
/**
 * 静态链表初始化
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class StaticLinkedListInit {
	//静态链表初始化
	public static boolean InitList(StaticLinkedList l){
		StaticNode[] space = l.getStaticArray();
		int size = l.getSize();
		for(int i=0;i<size-1;++i){
			space[i].setCur(i+1);
		}
		space[size-1].setCur(0);
		return true;
	}
}
