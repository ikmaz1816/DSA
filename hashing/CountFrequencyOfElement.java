package hashing;

import java.util.HashMap;

public class CountFrequencyOfElement {
	public static void main(String[] args) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int[] arr= {1,2,2,3,4,3};
		for(int i:arr)
		{
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		
		System.out.println(map);
	}
}
