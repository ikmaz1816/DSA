package recursionhardproblem;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
	public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        // target =2 and string 211 2*1*1 
        operations(num,"",target,ans,0,0,0);
        return ans;
    }

    public void operations(String num,String p,int target,List<String> ans,int index,long prev,long currentSum)
    {
        if(index==num.length())
        {
            if(currentSum==target)
            {
                ans.add(p);
            }
            return;
        }

        String str="";
        long current = 0;
        for(int i=index;i<num.length();i++)
        {
            char ch = num.charAt(i);
            if(i>index && num.charAt(index)=='0') 
                break;
            str+=ch;
            current = current * 10 + (num.charAt(i)-'0');
            if(index==0)
                operations(num,p+str,target,ans,i+1,current,current);
            else
            {
                operations(num,p+"+"+str,target,ans,i+1,current,current+currentSum);
                operations(num,p+"-"+str,target,ans,i+1,-current,currentSum-current);
                //As in this if we have 2 suppose and coming number is 3 
                //then we will -2 and multiply with 3
                //hence we multiplied currentSum-prev+(prev*current)
                operations(num,p+"*"+str,target,ans,i+1,current*prev,currentSum-prev+(prev*current));
            }
        }
    }
}
