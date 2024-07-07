package bsonproblems;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length,m=nums2.length;
        if(n>m)
            return findMedianSortedArrays(nums2,nums1);
        int start = 0;
        int end = n;
        int position = (n+m+1)>>1;
        while(start<=end)
        {
            int cut1 = (start+end)/2;
            int cut2 = position - cut1;
            
            int left1 = cut1==0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int left2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int right1 = cut1==n ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2==m ? Integer.MAX_VALUE : nums2[cut2];
            
            if(left1<=right2 && left2<=right1)
            {
                if((n+m)%2==0)
                {
                    return (Math.max(left1,left2) + Math.min(right1,right2))/2.0;
                }
                else
                     return Math.max(left1,left2);
            }

            if(left1<right2)
                start = cut1 + 1;
            else
                end = cut1 - 1;

        }
        return 0.0;
    }
}
