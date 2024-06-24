package arrayhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumTo0 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ls =new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        int i=0;
        while(i<length)
        {
            while(i>0 && i<nums.length && nums[i]==nums[i-1])
                i++;
            if(i>nums.length-2)
                break;
            int j=i+1;
            int k=length-1;
            while(j<k)
            {
                int target = nums[i] + nums[j] +nums[k];
                if(target==0)
                {
                    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k]));
                    ls.add(ans);
                    j++;
                    while(j<k && nums[j]==nums[j-1])
                        j++;
                    k--;
                    while(j<k && nums[k]==nums[k+1])
                        k--;
                }
                else if(target>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
            i++;
        }
        return ls;
    }
}
