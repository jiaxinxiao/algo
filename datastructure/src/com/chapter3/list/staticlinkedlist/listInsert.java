package com.chapter3.list.staticlinkedlist;

import com.chapter3.list.util.LinkedListUtil;

/**
 * 静态链表插入元素
 * @author jiaxinxiao
 * @date 2019年10月23日
 */
public class StaticLinkedListInsert {
	//在l的第i个位置之前插入element
//	public boolean listInsert(StaticLinkedList list,int i,String element){
//		int j = 0,k = 0;
//		k = list.getSize()-1;//最后一个元素下标，也是数组的下标
//		if(i < 0 || i > list.getCount()+1/*这里是在第i个元素之前，所以i的最大值是可以取count+1*/){
//			System.out.println("元素插入位置不合法");
//			return false;
//		}
//		//获取空闲空间分量的下标
//		j = LinkedListUtil.malloc_SLL(list);
//		if(j > 0 && j <= k){
//			StaticNode[] array = list.getStaticArray();
//			//将数据分给此分量的data
//			array[j].setData(element);
//			int l = 0;
//			int cur = 0;
//			for(;l<i;l++){//找到第i个元素之前的位置
//				cur = array[l].getCur();//记录第i个元素前一个元素的cur  
//			}
//			//头结点记录空闲空间cur所指向的空闲空间
////			array[0].setCur(array[l].getCur()); 这一步已经在malloc_SLL函数中实现了
//			array[l].setCur(j);//第i个元素的前一个的cur赋值给新元素
//			array[j].setCur(cur);//新元素的cur记录原来第i个元素前一个元素的cur
//			return true;
//		}
//		return false;
//	}
	/**
	 * 静态链表插入（在l的第i个位置之前插入element）
	 * 在数组中实现不移动元素，确插入数据的操作
	 * @param list
	 * @param i
	 * @param element
	 * @return
	 */
	public boolean listInsert(StaticLinkedList list,int i,String element){
		int j = 0,k = 0;
		k = list.getSize()-1;//最后一个元素下标，也是数组的下标
		if(i < 0 || i > list.getCount()+1/*这里是在第i个元素之前，所以i的最大值是可以取count+1*/){
			System.out.println("元素插入位置不合法");
			return false;
		}
		//获取空闲空间分量的下标
		j = LinkedListUtil.malloc_SLL(list);
		if(j > 0 && j <= k){
			StaticNode[] array = list.getStaticArray();
			//将数据分给此分量的data
			array[j].setData(element);
			int l = 0;
			for(;l<i;l++){//找到第i个元素之前的位置
				k = array[k].getCur();//记录第i个元素前一个元素的cur  
			}
			//头结点记录空闲空间cur所指向的空闲空间
//				array[0].setCur(array[l].getCur()); 这一步已经在malloc_SLL函数中实现了
			array[j].setCur(k);//第i个元素的前一个的cur赋值给新元素
			array[k].setCur(j);//i前一个元素记录新元素的cur
			return true;
		}
		return false;
	}
}
