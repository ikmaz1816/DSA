package recursiongoodtoknow;

import java.util.Stack;

public class SortAStack {
	static void rearrange(Stack<Integer> s,int num)
    {
        if(s.isEmpty() || s.peek()<=num)
        {
            s.push(num);
            return;
        }
        int x = s.pop();
        rearrange(s,num);
        s.push(x);
    }
    static void sortStack(Stack<Integer> s)
    {
        if(s.isEmpty())
            return;
        int num = s.pop();
        sortStack(s);
        rearrange(s,num);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }
}
