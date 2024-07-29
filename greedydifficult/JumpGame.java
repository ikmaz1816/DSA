package greedydifficult;

public class JumpGame {
	public boolean canJump(int[] nums) {
        int maxReachable = 0,length=nums.length;
        for(int i=0;i<length;i++)
        {
            if(i>maxReachable)
                return false;
            maxReachable = Math.max(maxReachable,i+nums[i]);
        }
        return true;
    }
}
