package com.chapter3.tree;
/**
 * 孩子表示法
 * 查找某个结点的孩子和兄弟，只需要找到这个结点的孩子单链表
 * 找双亲比较麻烦，可以在头结点，增加一个指针域来记录双亲在数组中的下标位置（双亲孩子表示法）
 * @author jiaxinxiao
 * @date 2019年11月1日
 */
public class TreeStruct2 {
	CTBox[] nodes;//维护一个数组，用来存储链表头结点
	int r,n;//根结点位置和结点数
}
//孩子结点
class CTNode{
	int child;//表示子结点在数组中的下标
	CTNode next;//一个结点的多个子结点用链表表示
}
//链表头结点（该结点也是维护数组存储的数据类型）
class CTBox{
	TElemType data;
	CTNode firstChild;//指向第一个孩子结点
//	int parent;//记录双亲下标
}
