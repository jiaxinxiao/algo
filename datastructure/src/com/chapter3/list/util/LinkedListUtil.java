package com.chapter3.list.util;

import com.chapter3.list.staticlinkedlist.StaticLinkedList;
import com.chapter3.list.staticlinkedlist.StaticNode;

/**
 * 链表操作工具类
 * @author jiaxinxiao
 * @date 2019年10月22日
 */
public class LinkedListUtil {
	/**
	 * 静态链表结点释放
	 * 备用链表获取可用空间，头结点cur所指向的空间就是可用分量
	 * @param l
	 * @return
	 */
	public static int malloc_SLL(StaticLinkedList l){
		//获取静态链表维护的数组
		StaticNode[] space = l.getStaticArray();
		//当前数组第一个元素的cur存的值，就是要返回的第一个备用空闲的下标
		int i = space[0].getCur();
		if(i != 0){
			//由于要拿出一个分量来使用了，所以我们就得把它的下一个分量用来做备用
			space[0].setCur(space[i].getCur());
		}
		return i;
	}
	/**
	 * 将下标为k的元素回收至备用链表
	 * @param l
	 * @param k
	 */
	public static void free_SLL(StaticLinkedList l,int k){
		StaticNode[] space = l.getStaticArray();
		space[k].setCur(space[0].getCur());
		space[0].setCur(k);
	}
	//静态链表打印方法
	public static void print(StaticLinkedList l){
		int size = l.getSize();
		StaticNode[] array = l.getStaticArray();
		int cur = array[size-1].getCur();
//		boolean flag = true;
		int i = 1;//计数
		while(cur != 0){
			System.out.println("打印第"+i+"个元素："+array[cur].getData());
			cur = array[cur].getCur();
//			if(cur == 0){
//				break;
//			}
			++i;
		}
	}
	//返回L中数据元素的个数
	public int listLength(StaticLinkedList l){
		if(l == null){
			return -1;
		}
		StaticNode[] space = l.getStaticArray();
		if(space == null){
			return -1;
		}
		int i = space[l.getSize()-1].getCur();
		int j = 0;
		while(i != 0){
			i = space[i].getCur();
			++j;
		}
		return j;
	}
	
}
