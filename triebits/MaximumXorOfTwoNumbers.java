package triebits;

class TrieNode
{
    int data;
    TrieNode[] children;
    public TrieNode(int data)
    {
        this.data = data;
        children = new TrieNode[2];
    }
}
class Trie
{
    TrieNode root;
    public Trie()
    {
        root=new TrieNode(0);
    }

    public void insert(int num)
    {
        //we will be having the trie of 32 bits
        TrieNode temp =root;
        for(int i=31;i>=0;i--)
        {
            int data = (num>>i) & 1;
            if(temp.children[data]==null)
            {
                temp.children[data]=new TrieNode(data);
            }
            temp=temp.children[data];
        }
    }

    public int getMax(int num)
    {
        TrieNode temp =root;
        int max = 0;
        for(int i=31;i>=0;i--)
        {
            int data = (num>>i) & 1;
            if(temp.children[1-data]!=null)
            {
                max = max | (1<<i);
                temp =temp.children[1-data];
            }
            else
                temp=temp.children[data];
        }
        return max;
    }
}
public class MaximumXorOfTwoNumbers {
	
}
