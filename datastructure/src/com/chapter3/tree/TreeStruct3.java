package com.chapter3.tree;
/**
 * 孩子兄弟表示法
 * 任意一棵树，它的结点的第一个孩子如果存在就是唯一的
 * 它的结点的右兄弟存在也是唯一的
 * data 数据域
 * firstChild 第一个孩子的指针域
 * rightsib 右兄弟的指针域
 * @author jiaxinxiao
 * @date 2019年11月1日
 */
public class TreeStruct3 {
	CSNode node;
}
class CSNode{
	TElemType data;
	CSNode firstChild;
	CSNode rightsib;
}
