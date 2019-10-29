package com.chapter3.stackandqueue.arraystack;
/**
 * 共享顺序栈实现
 * @author jiaxinxiao
 * @date 2019年10月29日
 */
public class DoubleArrayStack {
	class Stack{
		private int data[];
		private int size;
		private int top1 = -1;
		private int top2;
		public Stack(){}
		public Stack(int size){
			this.data = new int[size];
			this.size = size;
			this.top2 = size;
		}
		
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int[] getData() {
			return data;
		}
		public void setData(int[] data) {
			this.data = data;
		}
		public int getTop1() {
			return top1;
		}
		public void setTop1(int top1) {
			this.top1 = top1;
		}
		public int getTop2() {
			return top2;
		}
		public void setTop2(int top2) {
			this.top2 = top2;
		}
	}
	//出栈
	public boolean push(Stack stack,int e,int stackNumber){
		int top1 = stack.getTop1();
		int top2 = stack.getTop2();
		//栈已满
		if(top2 == top1+1){
			return false;
		}
		if(stackNumber ==1){
			stack.getData()[top1++] = e;
			stack.setTop1(top1);
		}else{
			stack.getData()[top2++] = e;
			stack.setTop1(top2);
		}
		return true;
	}
	//入栈
	public int pop(Stack stack,int stackNumber){
		int e = -1;
		if(stackNumber == 1){
			int top1 = stack.getTop1();
			if(top1 == -1){
				return -1;
			}
			e = stack.getData()[top1--];
			stack.setTop1(top1);
		}else{
			int top2 = stack.getTop2();
			int size = stack.getSize();
			if(top2 == size){
				return -1;
			}
			e = stack.getData()[top2++];
			stack.setTop2(top2);
		}
		return e;
	}
}
