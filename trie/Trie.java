package trie;

public class Trie {
	TrieNode root;
    public Trie() {
        this.root=new TrieNode('/');
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
    }

    public int countWordsEqualTo(String word) {
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
                return 0;
        }
        return temp.isChild ? temp.childCount : 0;
    }

    public int countWordsStartingWith(String word) {
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
                return 0;
        }
        return temp.childCount;
    }

    public void erase(String word) {
        remove(root,word);
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
}
