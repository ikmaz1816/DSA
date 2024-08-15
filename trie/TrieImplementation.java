package trie;

class TrieNode
{
    char data;
    TrieNode[] children;
    int childCount;
    boolean isChild;
    public TrieNode(char data)
    {
        this.data = data;
        this.children = new TrieNode[26];
        this.childCount = 0;
        isChild=false;
    }
}
public class TrieImplementation {
	private TrieNode root;
    int wordCount;
    public TrieImplementation() {
        this.root=new TrieNode('/');
        this.wordCount=0;
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            int index =  ch - 'a';
            if(temp.children[index]==null)
            {
                temp.children[index] = new TrieNode(ch);
            }
            temp=temp.children[index];
            temp.childCount++;
        }
        temp.isChild=true;
        this.wordCount++;
    }
    
    public boolean search(String word) {
        TrieNode temp =root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            int index =  ch - 'a';
            if(temp.children[index]!=null)
            {
                temp=temp.children[index];
            }
            else
                return false;
        }
        return temp.isChild;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp =root;
        for(int i=0;i<prefix.length();i++)
        {
            char ch = prefix.charAt(i);
            int index =  ch - 'a';
            if(temp.children[index]!=null)
            {
                temp=temp.children[index];
            }
            else
                return false;
        }
        return true;
    }
    
    public int wordCount()
    {
    	return this.wordCount;
    }
    
    public void display()
    {
    	print(root,"");
    }

	private void print(TrieNode root, String s) {
		if(root.isChild)
		{
			System.out.println(s);
		}
		for(int i=0;i<26;i++)
		{
			if(root.children[i]!=null)
			{
				print(root.children[i],s+root.children[i].data);
			}
		}
	}
	
	public void remove(String word)
	{
		if(remove(root,word))
			this.wordCount--;
	}
	
	private boolean remove(TrieNode root, String s) {
		if(s.length()==0)
		{
			root.isChild=false;
			return true;
		}
		char ch = s.charAt(0);
        int index =  ch - 'a';
		if(root.children[index]!=null)
		{
			if(remove(root.children[index],s.substring(1))==false)
				return false;
		}
		else
			return false;
		if(root.children[index].childCount==1 && !root.children[index].isChild)
		{
			root.children[index].childCount--;
			root.children[index]=null;
		}
		else
			root.children[index].childCount--;
		return true;
		
	}
	
	public boolean wordBreak(String s)
    {
        if(s.length()==0)
        {
            return true;
        }
        for(int i=0;i<=s.length();i++)
        {
            String firstHalf = s.substring(0,i);
            String secondHalf = s.substring(i);
            if(search(firstHalf) && wordBreak(secondHalf))
                return true;
        }
        return false;
    }

	public static void main(String[] args) {
		TrieImplementation trie=new TrieImplementation();
		trie.insert("apple");
		trie.insert("app");
		trie.display();
		System.out.println(trie.wordCount());
		trie.remove("app");
		trie.display();
		System.out.println(trie.wordCount());
	}
    
}
