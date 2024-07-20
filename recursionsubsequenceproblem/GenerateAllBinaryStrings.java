package recursionsubsequenceproblem;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
	public static List<String> generateBinaryStrings(int n) {
        List<String> ans = new ArrayList<>();
        generate(n-1,"0",ans);
        generate(n-1,"1",ans);
        return ans;
  }
  
  public static void generate(int n,String p,List<String> ans)
  {
      if(n==0)
      {
          ans.add(p);
          return;
      }
      if(p.charAt(p.length()-1)=='1')
        generate(n-1,p+'0',ans);
      else
      {
          generate(n-1,p+'0',ans);
          generate(n-1,p+'1',ans);
      }
  }
}
