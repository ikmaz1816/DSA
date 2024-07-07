package bsonproblems;

public class SplitArrayLargestSum {
	public int splitArray(int[] nums, int k) {
        int start=0;
        int end = 0;
        for(int i:nums)
        {
            end+=i;
            start=Math.max(start,i);
        }

        while(start<=end)
        {
            int mid = (start+end)/2;
            int sumTillMid = sumTillMid(nums,mid);
            if(sumTillMid>k)
                start=mid+1;
            else
                end=mid-1;
        }
        return start;
    }

    public int sumTillMid(int[] nums,int mid)
    {
        int count=1,sum=0;
        for(int i:nums)
        {
            if(sum+i>mid)
            {
                sum=i;
                count++;
            }
            else
                sum+=i;
        }
        return count;
    }
}
