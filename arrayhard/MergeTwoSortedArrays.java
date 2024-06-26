package arrayhard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	       if(n==0)
	        return;
	       int i=0,j=0;
	       while(i<m && j<n)
	       {
	          if(nums1[i]<=nums2[j])
	          {
	            i++;
	          }
	          else
	          {
	            int temp = nums1[i];
	            nums1[i] = nums2[j];
	            nums2[j] = temp;
	            i++;
	            Arrays.sort(nums2);
	          }
	       }
	       while(j<n)
	       {
	        nums1[i++]=nums2[j++];
	       }
	    }
}
