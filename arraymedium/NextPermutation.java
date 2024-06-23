package arraymedium;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) 
            i--;
        int j=nums.length-1;
        if(i>=0)
        {
            while(j>=0 && nums[i]>=nums[j])
                j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }

    public void swap(int[] nums,int start,int end)
    {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void reverse(int[] nums,int start,int end)
    {
        while(start<end)
        {
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
