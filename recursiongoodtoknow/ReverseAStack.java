package recursiongoodtoknow;

import java.util.Stack;

public class ReverseAStack {
	static void reverse(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        int num = s.pop();
        reverse(s);
        rearrange(s,num);
    }
    
    static void rearrange(Stack<Integer> s,int num)
    {
        if(s.isEmpty())
        {
            s.push(num);
            return;
        }
        int x = s.pop();
        rearrange(s,num);
        s.push(x);
    }
}
