package arrayhard;

import java.util.ArrayList;
import java.util.HashMap;

public class XorSumEqualsK {
	public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer> map=new HashMap<>();
        /*
         	Consider the first half of the array to be x
         	The second half to be k 
         	x ^ k = i i-> but the whole exor
         	if i xor k on both sides
         	x = xr ^ k
         */
        map.put(0,1);
        int count =0, xr=0;
        for(int i:A)
        {
            xr^=i;
            int x = B^xr;
            if(map.containsKey(x))
            {
                count+=map.get(x);
            }
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return count;
    }
}
