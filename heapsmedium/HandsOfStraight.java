package heapsmedium;

import java.util.TreeMap;

public class HandsOfStraight {
	public boolean isNStraightHand(int[] hand, int groupSize) {
        int length = hand.length;
        if(length%groupSize!=0) 
            return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i:hand)
            map.put(i,map.getOrDefault(i,0)+1);
        while(map.keySet().size()>0)
        {
            int size = groupSize;
            int i = map.keySet().iterator().next();
            if(map.get(i)==1)
                map.remove(i);
            else
                map.put(i,map.get(i)-1);
            size--;
            while(size>0)
            {
                i++;
                if(map.containsKey(i))
                {
                    if(map.get(i)==1)
                        map.remove(i);
                    else
                        map.put(i,map.get(i)-1);
                }
                else
                    return false;
                size--;
            }
        }
        return true;
    }
}
