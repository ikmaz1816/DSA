package stackproblems;

import java.util.Stack;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] nge=new int[length];
        int iterativeLength = 2 * length;
        Stack<Integer> st = new Stack<>();
        for(int i=iterativeLength-1;i>=0;i--)
        {
        	//Here there can be duplicate elements
            while(!st.isEmpty() && nums[i%length]>=st.peek())
            {
                st.pop();
            }
            if(st.isEmpty()) 
                nge[i%length] =-1;
            else 
                nge[i%length] = st.peek();
            st.push(nums[i%length]);
        }
        return nge;
    }
}
