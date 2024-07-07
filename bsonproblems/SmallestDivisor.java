package bsonproblems;

public class SmallestDivisor {
	public int smallestDivisor(int[] nums, int threshold) {
        /*
            The question is quite related to koko eating bananas
            As we have to find the minimum threshold 
            minimum is 1 and maximum is the max in the array

        */
        int end=-1,start=1;
        for(int i:nums)
        {
            end = Math.max(end,i);
        }
        while(start<=end)
        {
            int mid =(start+end)/2;
            int numberOfDivisors = countDivisor(nums,mid,threshold);
            if(numberOfDivisors<=threshold)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        return start;
    }

    public int countDivisor(int[] nums,int mid,int h)
    {
        int count=0;
        for(int i:nums)
        {
            count+=Math.ceil((i*1.0)/mid);
        }
        return count;
    }
}
