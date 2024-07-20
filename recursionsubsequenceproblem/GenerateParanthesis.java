package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n,"",0,0,ans);
        return ans;
    }

    public static void generate(int n,String p,int open,int closed,List<String> ans)
    {
        if(open+closed == 2*n)
        {
            ans.add(p);
            return;
        }
        if(open<n)
            generate(n,p+'(',open+1,closed,ans);
        if(closed<open)
            generate(n,p+')',open,closed+1,ans); 
    }
    
    public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
