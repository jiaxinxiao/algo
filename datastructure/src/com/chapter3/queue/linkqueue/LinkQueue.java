package com.chapter3.stackandqueue.linkqueue;
/**
 * 链队列实现
 * @author jiaxinxiao
 * @date 2019年10月31日
 */
public class LinkQueue {
	Node linkQueue;
	Node head;
	Node tail;
	class Node{
		String data;
		Node next;
	}
	void init(){
		linkQueue = new Node();
		head = linkQueue;
		tail = linkQueue;
	}
	//入队
	boolean enqueue(String e){
		Node node = new Node();
		node.data = e;
		tail.next = node;
		tail = node;
		return true;
	}
	//出队
	String dequeue(){
		String result = null;
		if(head == tail){
			return result;
		}
		Node p =  head.next;
		result = p.data;
		head.next = p.next;
		if(p == tail){
			//如果是最后一个结点，将删除后将尾指针指向头结点
			tail = head;
		}
		return result;
	}
	public static void main(String[] args) {
		LinkQueue lq = new LinkQueue();
		lq.init();
		System.out.println(lq.linkQueue);
		System.out.println(lq.enqueue("1"));
		System.out.println(lq.enqueue("2"));
		System.out.println(lq.enqueue("3"));
		System.out.println(lq.enqueue("4"));
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
		System.out.println(lq.dequeue());
	}
}
