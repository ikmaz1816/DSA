package trie;

public class LongestPrefix {
	private static String ans="";

	  public static void completeString(String s,TrieNode root)
	  {
	    if(ans.length()<s.length())
	    {
	      ans=s;
	    }
	    for(int i=0;i<26;i++)
	    {
	      if(root.children[i]!=null && root.children[i].isChild)
	      {
	        completeString(s+root.children[i].data,root.children[i]);
	      }
	    }
	  }

	  public static String completeString(int n, String[] a) {
	      Trie trie=new Trie();
	      for(int i=0;i<n;i++)
	      {
	        trie.insert(a[i]);
	      }
	      completeString("",trie.root);
	      return ans.length()==0 ? "None" : ans;
	  }
}
