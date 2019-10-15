package com.array;
/**
 * System.arraycopy()方法测试
 * public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
 * Object src : 原数组  
 * int srcPos 从元数据的起始位置开始 
 * Object dest : 目标数组  
 * int destPos : 目标数组的开始起始位置  
 * int length  : 要copy的数组的长度
 * 
 * 1.深复制还是浅复制
 * 2.String 的一维数组和二维数组复制是否有区别
 * 3.线程安全，还是不安全
 * 4.高效还是低效
 * 未完待续...
 * @author jiaxinxiao
 * @date 2019年10月15日
 */
public class TestArrayCopy {
	public static void printArray(String[] array){
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
	public static void printArray(User[] array){
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
	public static void main(String[] args) {
//		String[] s1 = {"s1","s2","s3"};  
//		printArray(s1);
//		String[] s2 = new String[10];
//		System.arraycopy(s1, 0, s2, 0, 3); 
//		printArray(s2);
//		s2[2] = "s4";
//		printArray(s2);
//		printArray(s1);
//		System.out.println("---------------------------------");
//		String[][] s3 = {{"s1","s2","s3"},{"s4","s5","s6"}};
//		String[][] s4 = new String[s3.length][s3[0].length];
//		System.arraycopy(s3, 0, s4, 0, 2);
//		printArray(s3[0]);
//		printArray(s3[1]);
//		printArray(s4[0]);
//		printArray(s4[1]);
//		s4[0][0] = "s11";
//		s4[1][2] = "s66";
//		printArray(s4[0]);
//		printArray(s4[1]);
//		printArray(s3[0]);
//		printArray(s3[1]);
		//1.对象数组的复制
		User[] srcUser = {new User(1, "xiaoming"),new User(2, "xiaohong")};
		User[] targetUser = new User[srcUser.length];
		System.arraycopy(srcUser, 0, targetUser, 0, 2);//对象数组的复制，复制的是引用，所以修改副本时，会影响原来的数组
		System.out.println(srcUser[0] == targetUser[0]?"浅复制":"深复制");
		System.out.println("比较两个对象的地址是否相同："+ (srcUser == targetUser));//false
		printArray(srcUser);
		printArray(targetUser);
		targetUser[1].setName("xiaozhang");
		printArray(srcUser);
		printArray(targetUser);
		//2.一维数组的复制
		String[] st  = {"A","B","C","D","E"};
        String[] dt  = new String[5];
        System.arraycopy(st, 0, dt, 0, 5);
        System.out.println("两个数组地址是否相同：" + (st == dt)); //false
        System.out.println("两个数组地址是否相同：" + (st[0] == dt[0])); //true 为什么是true？
        //改变dt的值
        dt[0] = "M";
        System.out.println("两个数组地址是否相同：" + (st[0] == dt[0])); //false
        /**
         * 在System.arraycopy()进行复制的时候，首先检查了字符串常量池是否存在该字面量，
         * 一旦存在，则直接返回对应的内存地址，如不存在，则在内存中开辟空间保存对应的对象。
         */
        printArray(st);
        printArray(dt);
		
	}
}
class User{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString(){
		return "User[id="+id+",name="+name+"]";
	}
}
