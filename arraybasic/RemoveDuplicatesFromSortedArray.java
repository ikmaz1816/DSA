package arraybasic;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int i=0;
        int j=i+1;
        int length = nums.length;
        while(j<length)
        {
            if(nums[i] != nums[j])
            {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
