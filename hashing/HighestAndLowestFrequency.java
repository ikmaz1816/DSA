package hashing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HighestAndLowestFrequency {
	public static void main(String[] args) {
		Map<Integer,Integer> mp=new TreeMap<>();
		int[] arr= {1,2,2,3,4,3};
		for(int i:arr)
		{
			mp.put(i, mp.getOrDefault(i, 0)+1);
		}
		Map<Integer,Integer> map= mp.entrySet().stream().
				sorted(Map.Entry.comparingByValue()).
				collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));
		int count = 0;
		for(Map.Entry<Integer, Integer> m : map.entrySet())
		{
			if(count==0 || count==map.size()-1)
			{
				System.out.println(m.getKey()+" "+m.getValue());
			}
			count++;
		}
	}
}
