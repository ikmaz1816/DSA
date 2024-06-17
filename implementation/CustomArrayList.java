package implementation;

public class CustomArrayList<T> {

	private int size;
	private T[] arr;
	
	public CustomArrayList()
	{
		this.size=0;
		arr=(T[]) new Object[5];
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	public boolean isFull()
	{
		return this.size == arr.length;
	}
	
	public void add(T element)
	{
		if(isFull())
		{
			doubleArray();
		}
		arr[size++]=element;
	}

	private void doubleArray() {
		T[] arr1 = arr;
		int length = arr1.length;
		arr = (T[]) new Object[length * 2];
		for(int i=0; i<length;i++)
		{
			arr[i] = arr1[i];
		}
	}
	
	public void add(int index, T element){
		if(isEmpty() || index>arr.length)
		{
			return;
		}
		if(isFull())
		{
			doubleArray();
		}
		for(int i=size;i>index;i--)
		{
			arr[i] = arr[i-1];
		}
		arr[index] = element;
		size++;
	}
	
	public T remove(int index)
	{
		if(index > arr.length || isEmpty())
			return null;
		
		T element = arr[index];
		for(int i=index;i<size;i++)
		{
			arr[i] = arr[i+1];
		}
		size--;
		return element;
	}
	
	@Override
	public String toString()
	{
		StringBuffer sb=new StringBuffer();
		for(T i:arr)
		{
			if(i!=null)
				sb.append(i+" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		list.add(2, 10);
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
	}
}
