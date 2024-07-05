package stackproblems;

import java.util.Stack;

public class AsteroidCollision {
	public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        int length = asteroids.length;
        for(int i=0;i<length;i++)
        {
            boolean flag=false;
            int element = asteroids[i];
            if(st.isEmpty() || element>0)
                st.push(element);
            else if(st.peek()<0 && element<0)
                st.push(element);
            else
            {
                int peek = st.peek();
                while(peek<=-element && peek>0)
                {
                    if(peek==-element)
                    {
                        st.pop();
                        flag=true;
                        break;
                    }
                    else
                    {
                        st.pop();
                        if(st.isEmpty())
                            break;
                        peek = st.peek();
                    }
                }
                if((st.isEmpty() || peek<0) && !flag)
                {
                    st.push(element);
                }
            }
            
        }
        int size = st.size();
            int[] ans = new int[size];
            for(int i=0;i<size;i++)
            {
                ans[i] = st.pop();
            }
            reverse(ans,0,size-1);
            return ans;
    }

    public void reverse(int[] ans,int start,int end)
    {
        while(start<end)
        {
            int temp =ans[start];
            ans[start] = ans[end];
            ans[end]=temp;
            start++;
            end--;
        }
    }
}
