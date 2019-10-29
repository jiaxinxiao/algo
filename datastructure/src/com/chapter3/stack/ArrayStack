package com.chapter3.stackandqueue.arraystack;
/**
 * 顺序栈实现
 * @author jiaxinxiao
 * @date 2019年10月29日
 */
public class ArrayStack {
	class Stack{
		private int[] data;//数组
		private int top = -1;//栈顶指针
		private int size;//栈容量
		public Stack(){}
		public Stack(int size){
			data = new int[size];
			this.setSize(size);
		}
		public int[] getData() {
			return data;
		}
		public void setData(int[] data) {
			this.data = data;
		}
		public int getTop() {
			return top;
		}
		public void setTop(int top) {
			this.top = top;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
	}
	/**
	 * 入栈
	 * @param stack
	 * @param element
	 * @return
	 */
	public boolean push(Stack stack,int element){
		int top = stack.getTop();
		if(top == stack.getSize()-1){
			return false;
		}
		stack.setTop(++top);
		stack.getData()[top] = element;
		return true;
	}
	/**
	 * element 弹出元素
	 * @param stack
	 * @param element
	 * @return
	 */
	public boolean pop(Stack stack,int element){
		int top = stack.getTop();
		if(top == -1){
			return false;
		}
		element = stack.getData()[top--];
		stack.setTop(top);
		return true;
	}
	public static void main(String[] args) {
		ArrayStack as = new ArrayStack();
		Stack stack = as.new Stack(5);
		as.push(stack, 10);
		System.out.println(stack.getData()[0]);
		int element = 0;
		as.pop(stack, element);
//		System.out.println(element); 输出0，int类型非引用类型
		System.out.println(stack.getTop());
	}
}
