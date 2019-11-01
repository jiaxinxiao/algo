package com.chapter3.tree;
/**
 * 双亲表示法
 * 树结构
 * 根结点没有双亲，所以双亲指针约定为-1
 * 结点的孩子，需要遍历整个结构时间复杂度O(n)
 * 可以将树结点结构扩展为有双亲域、长子域、右兄弟域
 * @author jiaxinxiao
 * @date 2019年11月1日
 */
public class TreeSruct1 {
	PTNode[] nodes;//结点数组
	int r,n;//根的位置和结点数
}
//树结点存储的数据类型
class TElemType{}
//树结点结构
class PTNode{
	TElemType data;//数据域
	int parent;//双亲结点
}
