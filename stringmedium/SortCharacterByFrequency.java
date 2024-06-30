package stringmedium;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharacterByFrequency {
	public String frequencySort(String s) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        int length = s.length();
        for(int i=0;i<length;i++)
        {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        map = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1,LinkedHashMap::new));

        StringBuilder sb=new StringBuilder();
        for(Character c : map.keySet())
        {
            int i = map.get(c);
            while(i>0)
            {
                sb.append(c);
                i--;
            }
        }
    return sb.toString();
    }
}
