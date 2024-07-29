package heaphard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

class Combination
{
    int data;
    int firstindex;
    int secondindex;
    public Combination(int data,int firstindex,int secondindex)
    {
        this.data=data;
        this.firstindex=firstindex;
        this.secondindex=secondindex;
    }
}
public class MaximumCombinationSum {
	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        Collections.sort(A);
        Collections.sort(B);
        int length = A.size();
        int i=length-1,j=length-1;
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        PriorityQueue<Combination> pq = new PriorityQueue<>((a,b)->b.data-a.data);
        pq.add(new Combination(A.get(i)+B.get(j),i,j));
        set.add(""+i+j);
        while(C>0)
        {
            Combination combination = pq.poll();
            int sum = combination.data;
            int firstindex = combination.firstindex;
            int secondindex = combination.secondindex;
            ans.add(sum);
            firstindex-=1;
            if(firstindex>=0 && secondindex>=0 && !set.contains(""+firstindex+secondindex))
            {
                pq.add(new Combination(A.get(firstindex)+B.get(secondindex),firstindex,secondindex));
                set.add(""+firstindex+secondindex);
            }
            firstindex+=1;
            secondindex-=1;
            if(firstindex>=0 && secondindex>=0 && !set.contains(""+firstindex+secondindex))
            {
                pq.add(new Combination(A.get(firstindex)+B.get(secondindex),firstindex,secondindex));
                set.add(""+firstindex+secondindex);
            }
            C--;
        }
        return ans;
    }
}
