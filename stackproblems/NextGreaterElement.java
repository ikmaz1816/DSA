package stackproblems;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int length = nums2.length;
        for(int i=length-1;i>=0;i--)
        {
        	//there are no duplicate elements
            while(st.size()>0 && nums2[i]>st.peek())
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                map.put(nums2[i],-1);
            }
            else
            {
                map.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
        }
        length = nums1.length;
        int[] ans = new int[length];
        for(int i=0;i<length;i++)
        {
            ans[i]=map.get(nums1[i]);
        }
        return ans;
    }
}
