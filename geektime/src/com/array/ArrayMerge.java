package com.array;

import java.util.Arrays;
/**
 * 合并两个有序数组
 * @author jiaxinxiao
 * @date 2019年10月15日
 */
public class ArrayMerge {
	public static void printArray(int[] array){
		if(array == null || array.length == 0){
			return;
		}
		for(int i=0;i<array.length;i++){
			if(i == array.length-1){
				System.out.print(array[i]+"\n");
			}else{
				System.out.print(array[i]+", ");
			}
		}
	}
	//时间复杂度O((m+n)log(m+n)) 空间复杂度O(1)
	public static void merge1(int[] array1,int m,int[] array2,int n){
		/**
		 * System中提供了一个native静态方法arraycopy(),可以使用这个方法来实现数组之间的复制。对于一维数组来说，
		 * 这种复制属性值传递，修改副本不会影响原来的值。对于二维或者一维数组中存放的是对象时，复制结果是一维的引用变量传递给副本的一维数组，
		 * 修改副本时，会影响原来的数组。
		 */
		System.arraycopy(array2, 0, array1, m, n);
		Arrays.sort(array1);
	}
	/**
	 * m为array1中元素个数,array1.length >= m+n;n为array2的容量
	 * 时间复杂度O(m+n)
	 * 空间复杂度O(m)
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 */
	public static void merge2(int[] array1,int m,int[] array2,int n){
		//初始化array1 副本
		int[] array1_copy = new int[m];
		System.arraycopy(array1, 0, array1_copy, 0, m);
		
		//初始化两个指针分别指向array1_copy和array2
		int p1 = 0;
		int p2 = 0;
		
		//初始化指针指向array1
		int p = 0;
		
		//比较array1_copy 和 array2，将较小的数值添加到 array1中
		while((p1<m) && (p2<n)){
			array1[p++] = array1_copy[p1]<array2[p2]?array1_copy[p1++]:array2[p2++];
		}
		
		//处理剩余元素
		//当array1_copy还有剩余元素，因为两个数组都是有序数组，所以将剩余有序部分直接copy到array1中即可
		if(p1<m){
			System.arraycopy(array1_copy, p1, array1, p1+p2, m+n-p1-p2);
		}
		if(p2<n){
			System.arraycopy(array2, p2, array1, p1+p2, m+n-p1-p2);
		}
	}
	/**
	 * 时间复杂度O(m+n)
	 * 空间复杂度O(1)
	 * @param array1
	 * @param m
	 * @param array2
	 * @param n
	 */
	public static void merge3(int[] array1,int m,int[] array2,int n){
		//初始化array1指针
		int p1 = m-1;
		int p = m+n-1;//arry1.length == (m+n)
		
		//初始化array2指针
		int p2 = n-1;
		
		while((p1>=0) && (p2>=0)){
			array1[p--] = array1[p1]>array2[p2]?array1[p1--]:array2[p2--];
		}
		System.arraycopy(array2, 0, array1, 0, p2+1);
	}
	//没有利用两个数组本身已经有序的特点
//	public static void main(String[] args) {
//		int[] array1 = {4,3,5,2,1,0,0,0,0,0};
//		int[] array2 = {10,8,9,7,6};
//		System.out.println("array1_length:"+array1.length+" array2_length:"+array2.length);
//		merge1(array1,5,array2,5);
//		printArray(array1);
//	}
	//测试merge2
//	public static void main(String[] args) {
//		int[] array1 = {1,3,5,8,10,0,0,0,0,0};
//		int[] array2 = {2,4,5,9,11};
//		merge2(array1,5,array2,5);
//		printArray(array1);
//	}
	public static void main(String[] args) {
		int[] array1 = {10,10,15,18,19,0,0,0,0,0};
		int[] array2 = {2,4,5,9,11};
		merge3(array1,5,array2,5);
		printArray(array1);
	}
}
