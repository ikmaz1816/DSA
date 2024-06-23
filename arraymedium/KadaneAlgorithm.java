package arraymedium;

public class KadaneAlgorithm {
	public int maxSubArray(int[] nums) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        for(int i:nums)
        {
            sum+=i;
            max = Math.max(max,sum);
            if(sum<0)
                sum=0;
        }
        return max;
    }
}
