package com.array;
/**
 * 实现一个动态扩容的数组
 * @author jiaxinxiao
 * @date 2019年10月14日
 */
public class GenericArray<T> {
	private T[] data;
	private int size;
	//数组初始化	
	@SuppressWarnings("unchecked")
	public GenericArray(int capacity){
		this.data = (T[]) new Object[capacity];
		this.size = 0;
	}
	//无参初始化
	public GenericArray(){
		this(10);
	}
	//获取容量
	public int getCapacity(){
		return data.length;
	}
	//下标合法性检查（add）
	private void checkIndexForAdd(int index) {
		if(index < 0 || index > size){
			throw new IllegalArgumentException("illegal index!Required add index >= 0 and index <= size");
		}
	}
	//下标合法性检查（get or remove）
	private void checkIndexForGetOrRemove(int index) {
		if(index < 0 || index >= size){
			throw new IllegalArgumentException("illegal index!Required add index >= 0 and index < size");
		}
	}
	//扩容/缩容 方法，时间复杂度O(n)
	@SuppressWarnings("unchecked")
	public void resize(int capacity){
		T[] newData = (T[]) new Object[capacity];
		//数据搬移
		for(int i=0;i<size;i++){
			newData[i] = data[i];
		}
		this.data = newData;
	}
	//查询（获取下标为index的元素）
	public T get(int index){
		//index合法性检查
		checkIndexForGetOrRemove(index);
		return data[index];
	}
	//在index位置 添加元素 时间复杂度O(m+n)?
	public void add(int index,T e){
		checkIndexForAdd(index);
		//数组已满
		if(size == data.length){
			resize(2*size);
		}
//		data[index] = e;未考虑数据的搬移（保证内存与数据的连续性）
		for(int i = size;index<i;i--){
			data[i] = data[i-1];
		}
		data[index] = e;
		//添加元素后计数
		size++;
	}
	//在index位置 移除元素
	public T remove(int index){
		checkIndexForGetOrRemove(index);
		T ret = data[index];
		//数据搬移
		for(int i = index;i<size-1;i++){
			data[i] = data[i+1];
		}
		//计数
		data[--size] = null;
		//缩容(预留空间，防止频繁扩容)
		if(size == data.length / 4 && data.length / 2 != 0){
			resize(data.length / 2);
		}
		return ret;
	}
	//数组头部插入元素
	public void addFirst(T e){
		add(0,e);
	}
	//数组尾部插入元素
	public void addLast(T e){
		add(size,e);
	}
	// 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }
    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }
    //查找元素id
    public int find(T e){
    	for(int i=0;i<size;i++){
    		if(data[i] == e){
    			return i;
    		}
    	}
    	return -1;
    }
    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }
    // 查看数组是否包含元素e
    public boolean contain(T e){
    	for(int i=0;i<size;i++){
    		if(data[i] == e){
    			return true;
    		}
    	}
    	return false;
    }
    @Override
    public String toString(){
    	StringBuilder sb = new StringBuilder();
    	sb.append(String.format("Array size = %d,capacity = %d \n", size,data.length));
    	sb.append("[");
    	for(int i=0;i<size;i++){
    		sb.append(data[i]);
    		if(i != size -1){
    			sb.append(", ");
    		}
    	}
    	sb.append("]");
    	return sb.toString();
    }
    //测试
	public static void main(String[] args) {
		GenericArray<String> array = new GenericArray<String>();
		System.out.println(array.toString());
		array.add(0, "1");
		array.add(0, "2");
		array.add(0, "3");
		array.add(0, "4");
		array.add(0, "5");
		array.add(0, "6");
		array.add(0, "7");
		array.add(0, "8");
		array.add(0, "9");
		array.add(0, "10");
		array.add(0, "11");
		array.add(0, "12");
		array.add(0, "13");
		System.out.println(array.toString());
		array.remove(0);
		array.remove(0);
		array.remove(0);
		System.out.println(array.toString());
		array.remove(0);
		array.remove(0);
		array.remove(0);
		array.remove(0);
		array.remove(0);
		System.out.println(array.toString());
	}
}
