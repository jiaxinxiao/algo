package com.chapter3.list;

import java.util.Random;

/**
 * 单链表整表创建
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class SingleLinkedListCreate {
//	private static Random rand = new Random();
	//单链表整表创建（头插法）
	public static void createListHead(SingleLinkedList l,int n){
		//声明结点p
		SingleNode p = null;
		//声明计数器
		int i = 0;
		//初始化带头结点的单链表
		l.setHeadNode(new SingleNode(null,null));
		while(i<n){
			//生成新结点复制给p
			p  = new SingleNode();
//			p.data = String.valueOf(rand.nextInt(100));
			//使用递增数字，便于区分头插法和尾插法
			p.data = String.valueOf(i+1);
			//将p插入头结点与新结点之间
			p.next = l.getHeadNode().next;
			l.getHeadNode().next = p;
			l.setSize(++i);
		}
	}
	//单链表创建（尾插法）
	public static void createListTail(SingleLinkedList l,int n){
		SingleNode p = new SingleNode(null,null);
		int i = 0;
		l.setHeadNode(p);
		while(i<n){
			SingleNode node = new SingleNode();
			node.data = String.valueOf(i+1);
			node.next = p.next;
			p.next = node;
			p = node;
			l.setSize(++i);
		}
	}
	//打印单链表
	public static void print(SingleLinkedList l){
		if(l == null || l.getSize() <= 0){
			System.out.println("无效单链表");
		}
		//获取size
		int size = l.getSize();
		//获取头结点
		SingleNode nextNode = l.getHeadNode().next;
		int i = 1;
		System.out.println("链表总长度为："+size);
		while(i<=size){
			System.out.println("输出第"+i+"个结点："+nextNode.data);
			nextNode = nextNode.next;
			++i;
		}
	}
	public static void main(String[] args) {
		SingleLinkedList headl = new SingleLinkedList();
		createListHead(headl,10);
		print(headl);
		SingleLinkedList taill = new SingleLinkedList();
		createListTail(taill,10);
		print(taill);
	}
}
