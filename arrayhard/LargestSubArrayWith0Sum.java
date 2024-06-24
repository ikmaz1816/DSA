package arrayhard;

import java.util.HashMap;

public class LargestSubArrayWith0Sum {
	 int maxLen(int arr[], int n)
	    {
	        HashMap<Integer,Integer> map = new HashMap<>();
	        int maxlen=0;
	        int index=0,sum=0;
	        for(int i:arr)
	        {
	            sum+=i;
	            if(sum==0)
	            {
	                maxlen=index+1;
	            }
	            if(map.containsKey(sum))
	            {
	                maxlen=Math.max(index-map.get(sum),maxlen);
	            }
	            if(!map.containsKey(sum))
	            {
	                map.put(sum,index);
	            }
	            index++;
	        }
	        return maxlen;
	    }
}
