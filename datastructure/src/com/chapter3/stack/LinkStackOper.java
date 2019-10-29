package com.chapter3.stackandqueue.arraystack;
/**
 * 链式栈实现
 * @author jiaxinxiao
 * @date 2019年10月29日
 */
public class LinkStackOper {
	//出栈
	public boolean push(LinkStack stack,String e){
		StackNode node = new StackNode();
		node.data = e;
		node.next = stack.top;
		stack.top = node;
		stack.count++;
		return true;
	}
	//入栈
	public String pop(LinkStack stack){
		String e = null;
		if(stack == null){
			return e;
		}
		StackNode p = stack.top;
		e = stack.top.data;
		stack.top = stack.top.next;
		free(p);
		stack.count--;
		return e;
	}
	//释放结点
	public void free(StackNode node){
		node.data = null;
		node.next = null;
	}
}
