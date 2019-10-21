package com.chapter3.list;
/**
 * 单链表插入结点与删除第i个结点
 * @author jiaxinxiao
 * @date 2019年10月21日
 */
public class SinglyLinkedList2 {
	//返回一个链表的头结点
	public static Node getHeadNode(){
		Node headNode = new Node(null, new Node("1", new Node("2", new Node("3", new Node("4", new Node("5", null))))));
		return headNode;
	}
	//单链表插入结点
	public static Node listInsert(Node headNode,Node insertNode,int i) {
		if(insertNode == null){
			System.out.println("请输入合法的插入结点");
		}
		Node p = headNode.next;//指针p指向第一个结点
		int j = 1;
		while(p != null && j<i){
			p = p.next;
			j++;
		}
		if(p == null){
			return null;
		}
//		System.out.println("当前指针与插入指针内存地址是否相同:"+(insertNode == p?"是":"否"));
		//判断当前指针所指结点的内存地址是否与插入结点的内存地址相同：如果相同，插入不合法（死循环）
		if(p == insertNode){
			return null;
		}
		//记录插入的结点
		Node result = insertNode;
		//p现在位于第i个结点，插入结点
		insertNode.next = p.next;
		p.next = insertNode;
		return result;
	}
	/**
	 * 删除第i个结点
	 * @param headNode 头结点
	 * @param i 删除第i个结点
	 * @return
	 */
	public static Node listDelete(Node headNode,int i){
		int j = 1;//计数器
		Node p = headNode.next;//初始化指针p指向第一个结点
		if(i<j){
			return null;
		}
		if(p.next == null && i == 1){
			p = null;
			return p;
		}
		//遍历链表，指针p指向第i个结点的前一个结点
		while(p != null && j < i-1){
			p = p.next;
			j++;
		}
		//将第i个元素赋值给q
		Node q = p.next;
		if(p == null || q == null){
			System.out.println("第i个元素不存在");
		}
		//如果第i个元素是最后一个结点
		if(q.next == null){
			p.next = null;
		}else{
			p.next = q.next;
		}
		return q;
	}
	//遍历链表
	public static void forEachList(Node headNode){
		if(headNode == null){
			System.out.println("请勿传入空链表");
		}
		Node p = headNode;
		while(p != null){
			p = p.next;
			if(p != null){
				System.out.print(p.data+(p.next == null?"":", "));
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Node headNode = getHeadNode();
		forEachList(headNode);
		Node insertNode = new Node("insert", null);
		forEachList(headNode);
		insertNode = new Node("insert2", null);
		listInsert(headNode,insertNode,4);
		forEachList(headNode);
		insertNode = new Node("insert3", null);
		listInsert(headNode,insertNode,7);
		forEachList(headNode);
	}
}
