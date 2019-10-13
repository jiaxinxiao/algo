package com.array;
/**
 * 数组
 * @author jiaxinxiao
 * @date2019年10月12日
 */
public class Array {
	private int[] items;
	private int n;
	private int count;
	
	public Array(int n){
		this.items = new int[n];
		this.n = n;
		this.count = 0;
	}
	
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
	
	public int[] getItems(Array array){
		return array.items;
	}
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
