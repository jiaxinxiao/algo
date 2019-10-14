package com.array;
/**
 * 数组
 * @author jiaxinxiao
 * @date2019年10月12日
 */
public class Array {
	private int[] items;//维护数组
	private int n;//数组大小
	private int count;//元素个数
	
	public Array(int n){
		this.items = new int[n];
		this.n = n;
		this.count = 0;
	}
	//根据下标查找
	public int find(int index){
		if(index <0 || index >= count){
			return 0;
		}
		return items[index];
	}
	//插入
	public boolean insert(int index,int value){
		if(count == n){
			return false;
		}
		if(index <0 || index > count){
			return false;
		}
//		for(int num = count-1;index<=num;num--){
//			items[num+1] = items[num]; 
//		}
		for(int i = count;i>index;i--){
			items[i] = items[i-1];
		}
		items[index] = value;
		count++;
		return true;
	}
	//删除
	public boolean delete(int index){
		if(index < 0 || index >= count){
			return false;
		}
		for(int i = count-1;index<i;index++){
			items[index] = items[index+1];
		}
		items[count-1] = 0;
		count--;
		return true;
	}
	//数组打印方法
	public static void print(Array array){
		int[] items = array.getItems(array);
		for(int i=0;i<items.length;i++){
			if(i == items.length-1){
				System.out.print(items[i]);
			}else{
				System.out.print(items[i]+",");
			}
		}
		System.out.println();
	}
	//测试
	public static void main(String[] args) {
		Array array = new Array(10);
//		System.out.println(array.n);
//		System.out.println(array.count);
		print(array);
		array.insert(0, 1);
		array.insert(1, 2);
		array.insert(2, 3);
		array.insert(3, 4);
		array.insert(4, 5);
		print(array);
		array.insert(2,55);
		print(array);
		array.insert(2,66);
		print(array);
		array.insert(2,77);
		print(array);
		array.insert(2,88);
		print(array);
		array.insert(2,99);
		print(array);
		boolean bol = array.insert(2,100);
		System.out.println(bol);
		print(array);
		array.delete(4);
		print(array);
		array.delete(0);
		print(array);
	}
}
