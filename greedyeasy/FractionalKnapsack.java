package greedyeasy;

import java.util.Comparator;
import java.util.PriorityQueue;

class Fractional
{
    int value,weight;
    double ratio;
    public Fractional(int value,int weight,double ratio)
    {
        this.value=value;
        this.weight=weight;
        this.ratio=ratio;
    }
}
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class FractionalKnapsack {
	double fractionalKnapsack(int w, Item arr[], int n) {
        PriorityQueue<Fractional> pq=new PriorityQueue<>(new Comparator<>()
        {
            public int compare(Fractional x,Fractional y)
            {
                if(y.ratio>x.ratio)
                    return 1;
                return -1;
            }
        });
        for(Item item:arr)
        {
            pq.add(new Fractional(item.value,item.weight,(item.value*1.0)/item.weight));
        }
        double ans = 0.0;
        while(!pq.isEmpty() && w>0)
        {
            Fractional p = pq.poll();
            if(p.weight<=w)
            {
                ans+=p.value;
                w-=p.weight;
            }
            else
            {
                ans+=(w*p.ratio);
                w=0;
            }
        }
        return ans;
	}
}
