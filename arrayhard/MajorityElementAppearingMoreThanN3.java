package arrayhard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementAppearingMoreThanN3 {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int element1=0;
        int element2=0;
        int count1=0;
        int count2=0;
        for(int i:nums)
        {
            if(count1==0 && (element2!=i || element2==0))
            {
                count1++;
                element1=i;
            }
            else if(count2==0 && element1!=i)
            {
                count2++;
                element2=i;
            }
            else if(element1==i)
            {
                count1++;
            }
            else if(element2==i)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i:nums)
        {
            if(i==element1)
            {
                count1++;
            }
            else if(i==element2)
            {
                count2++;
            }
        }
        int length = nums.length;
        if(count1>length/3)
            ans.add(element1);
        if(count2>length/3)
            ans.add(element2);
        return ans;
    }
}
