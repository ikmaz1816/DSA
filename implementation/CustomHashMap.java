package implementation;

import java.util.ArrayList;
import java.util.LinkedList;

class Node<K,V>
{
	private K key;
	private V value;
	
	public Node(K key,V value)
	{
		this.key=key;
		this.value=value;
	}
	
	public K getKey()
	{
		return this.key;
	}
	
	public V getValue()
	{
		return this.value;
	}
	
	public void setKey(K key)
	{
		this.key=key;
	}
	
	public void setValue(V value)
	{
		this.value=value;
	}
}

public class CustomHashMap<K,V> {
	
	private LinkedList<Node<K,V>>[] buckets;
	private int size;
	
	public CustomHashMap()
	{
		this.size = 0;
		init(4);
	}
	
	private void init(int bucketSize) {
		buckets = new LinkedList[bucketSize];
		for(int i=0;i<bucketSize;i++)
		{
			buckets[i]=new LinkedList<Node<K,V>>();
		}
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	private int hashcode(K key) {
		return Math.abs(key.hashCode())%buckets.length;
	}
	
	private int getIndexWithinBucket(int bucketIndex,K key) {
		int count=0;
		for(Node<K,V> node : buckets[bucketIndex])
		{
			if(node.getKey().equals(key))
			{
				return count;
			}
			count++;
		}
		return -1;
	}
	
	public void put(K key, V value)
	{
		int bucketIndex = hashcode(key);
		int indexInLinkedList = getIndexWithinBucket(bucketIndex,key);
		
		if(indexInLinkedList == -1)
		{
			Node<K,V> node = new Node<K,V>(key,value);
			buckets[bucketIndex].add(node);
			this.size++;
		}
		else
		{
			Node<K,V> node = buckets[bucketIndex].get(indexInLinkedList);
			node.setValue(value);
		}
		
		double lambda = (size * 1.0) / buckets.length;
		if(lambda > 2.0)
			rehash();
	}
	
	private void rehash() {
		LinkedList<Node<K,V>>[] hashBucket = buckets;
		int length = hashBucket.length;
		init(length);
		for(int i=0;i<length;i++)
		{
			for(Node<K,V> node : hashBucket[i])
			{
				put(node.getKey(), node.getValue());
			}
		}
	}
	
	public ArrayList<K> keySet()
	{
		int length = buckets.length;
		ArrayList<K> keys = new ArrayList<>();
		for(int i=0;i<length;i++)
		{
			for(Node<K,V> node : buckets[i])
			{
				keys.add(node.getKey());
			}
		}
		return keys;
	}
	
	public ArrayList<V> values()
	{
		int length = buckets.length;
		ArrayList<V> values = new ArrayList<>();
		for(int i=0;i<length;i++)
		{
			for(Node<K,V> node : buckets[i])
			{
				values.add(node.getValue());
			}
		}
		return values;
	}
	
	public boolean containsKey(K key)
	{
		int bucketIndex = hashcode(key);
		int indexInLinkedList = getIndexWithinBucket(bucketIndex,key);
		if(indexInLinkedList == -1)
			return false;
		return true;
	}
	
	public V get(K key)
	{
		int bucketIndex = hashcode(key);
		int indexInLinkedList = getIndexWithinBucket(bucketIndex,key);
		if(indexInLinkedList == -1)
			return null; // can throw exception as well
		return buckets[bucketIndex].get(indexInLinkedList).getValue();
	}
	
	public void remove(K key)
	{
		int bucketIndex = hashcode(key);
		int indexInLinkedList = getIndexWithinBucket(bucketIndex,key);
		if(indexInLinkedList == -1)
			return ; // can throw exception as well
		buckets[bucketIndex].remove(indexInLinkedList);
		this.size--;
	}
	
	public static void main(String[] args) {
		CustomHashMap<String,Integer> map=new CustomHashMap<>();
		map.put("Imran", 1);
		map.put("Imran", 2);
		map.put("Ayaan", 1);
		map.put("Alfred", 3);
		
		for(String string:map.keySet())
		{
			System.out.println(string);
		}
		
		for(Integer i:map.values())
		{
			System.out.println(i);
		}
		
		System.out.println(map.containsKey("Imran"));
		System.out.println(map.containsKey("George"));
		
		System.out.println(map.size());
		System.out.println(map.isEmpty());
		
		System.out.println(map.get("Imran"));
		map.remove("Imran");
		System.out.println(map.containsKey("Imran"));
	}
}
