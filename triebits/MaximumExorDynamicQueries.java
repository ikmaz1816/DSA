package triebits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Pair
{
    int number;
    int max;
    int index;
    public Pair(int number,int max,int index)
    {
        this.number=number;
        this.max=max;
        this.index=index;
    }
}
public class MaximumExorDynamicQueries {
	public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<Pair> ls=new ArrayList<>();
        int length = queries.length;
        for(int i=0;i<length;i++)
        {
            int xi = queries[i][0];
            int mi = queries[i][1];
            Pair p = new Pair(xi,mi,i);
            ls.add(p);
        }
        Collections.sort(ls,(a,b)->a.max-b.max);
        Trie trie =new Trie();
        int[] ans=new int[length];
        int index=0;
        for(int i:nums)
            System.out.print(i+" ");
        for(int i=0;i<length;i++)
        {
            while(index<nums.length && nums[index]<=ls.get(i).max)
            {
                trie.insert(nums[index]);
                index++;
            }
            ans[ls.get(i).index] = index==0 ? -1 : trie.getMax(ls.get(i).number);
        }
        return ans;
    }
}
