package com.chapter3.stackandqueue.arrayqueue;
/**
 * 循环队列实现（重点）
 * 头尾相接的顺序存储结构的队列叫作循环队列
 * 是否空队的判断条件  tail == head
 * 队满条件（始终保留一个空闲空间）
 * (tail+1)%size == head
 * 循环队列实现了以顺序结构为基础实现的栈
 * 将插入与删除的时间复杂度从O(n)降为O(1)
 * @author jiaxinxiao
 * @date 2019年10月29日
 */
public class CircularQueue {
	//维护一个顺序存储结构队列
	Queue q = null;
	int size;
	//循环队列结构
	class Queue{
		String[] data;
		int head;
		int tail;
		public Queue(int size){
			this.data =  new String[size];
		}
	}
	//初始化队列
	boolean initQueue(){
		if(q == null){
			q = new Queue(5);
		}
		q.head = 0;
		q.tail = 0;
		this.size = 5;
		return true;
	}
	//获取队列的长度
	int queueLength(){
		if(q == null){
			return -1;
		}
		int size = q.data.length;
		int head = q.head;
		int tail = q.tail;
		return (tail-head+size)%size;
	}
	//队尾入队
	boolean enQueue(String e){
		//队列已满
		if((q.tail+1)%size == q.head){
//			throw new RuntimeException();
			return false;
		}
		q.data[q.tail] = e;
		q.tail = (q.tail+1)%size;
		return true;
	}
	//队头出队
	String deQueue(){
		if(q.head == q.tail){
			return null;
		}
		String result = q.data[q.head];
		q.head = (q.head+1)%size;
		return result;
	}
	//测试
	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue();
		cq.initQueue();
		cq.enQueue("1");
		cq.enQueue("2");
		cq.enQueue("3");
		cq.enQueue("4");
		System.out.println(cq.enQueue("5"));
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.enQueue("5"));
		System.out.println(cq.enQueue("6"));
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
		System.out.println(cq.deQueue());
	}
}
