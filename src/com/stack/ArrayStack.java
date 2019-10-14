package com.stack;
/**
 * 数组实现的顺序栈
 * @author jiaxinxiao
 * @date 2019-10-13
 */
public class ArrayStack {
	private String[] items;
	private int n;
	private int count;
	
	public ArrayStack(int n){
		this.items = new String[n];
		this.n = n;
		this.count = 0;
	}
	//入栈
	public boolean push(String item){
		if(n == count){//栈已满
			return false;
		}
		items[count++] = item;//压入栈 count计数
		return true;
	}
	//出栈
	public String pop(){
		if(count == 0){
			return null;//栈已空，出栈null
		}
		return items[--count];
	}
	
	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(5);
		System.out.println(arrayStack.push("num1"));
		System.out.println(arrayStack.push("num2"));
		System.out.println(arrayStack.push("num3"));
		System.out.println(arrayStack.push("num4"));
		System.out.println(arrayStack.push("num5"));
		System.out.println(arrayStack.push("num6"));
		System.out.println(arrayStack.push("num7"));
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
	}	
}
