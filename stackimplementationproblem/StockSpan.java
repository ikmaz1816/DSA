package stackimplementationproblem;

import java.util.Stack;

public class StockSpan {
	public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> st=new Stack<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && price[i]>=price[st.peek()])
                st.pop();
            if(st.isEmpty())
            {
                ans[i] = i+1;
            }
            else
                ans[i] = i-st.peek();
            st.push(i);
        }
        return ans;
    }
}
