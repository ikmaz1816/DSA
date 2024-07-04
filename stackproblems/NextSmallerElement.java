package stackproblems;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st=new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int length = A.size();
        for(int i=0;i<length;i++)
        {
            while(!st.isEmpty() && A.get(i)<=st.peek())
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans.add(-1);
            }
            else
                ans.add(st.peek());
            st.push(A.get(i));
        }
        return ans;
    }
}
