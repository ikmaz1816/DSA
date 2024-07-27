package twopointerslidingwindowmedium;

import java.util.HashMap;

public class FruitIntoBasket {
	public static int totalFruits(Integer[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i=0,j=0,k=2,max=0,length=arr.length;
        while(j<length)
        {
            if(!map.containsKey(arr[j]))
            {
                k--;
            }
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(k<0)
            {
                int count = map.get(arr[i]);
                if(count==1)
                {
                    map.remove(arr[i]);
                    k++;
                }
                else
                    map.put(arr[i],count-1);
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
