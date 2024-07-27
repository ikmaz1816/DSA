package twopointerslidingwindowmedium;

public class NiceSubArrays {
	public int countNice(int[] nums,int k)
    {
        int i=0,j=0,length=nums.length;
        int ans =0;
        while(j<length)
        {
            if(nums[j]%2!=0)
                k--;
            while(k<0)
            {
                if(nums[i]%2!=0)
                    k++;
                i++;
            }
            j++;
            ans+=(j-i+1);
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return countNice(nums,k) - countNice(nums,k-1);
    }
}
