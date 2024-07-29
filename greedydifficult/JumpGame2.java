package greedydifficult;

public class JumpGame2 {
	public int jump(int[] nums) {
        int length = nums.length;
        if(length<=2)
            return length-1;
        int count = 1;
        int max = nums[0];
        int end = nums[0];
        
        for(int i=1;i<length-1;i++)
        {
            max=Math.max(max,i+nums[i]);
            if(i==end)
            {
                end=max;
                count++;
            }
            
        }
        return count;
	}
}
