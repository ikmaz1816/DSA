package trie;

public class DistinctSubstring {
	public static int countDistinctSubstrings(String s) 
	{
		TrieImplementation trieImplementation=new TrieImplementation();
		for(int i=0;i<s.length();i++)
		{
			for(int j=i;j<s.length();j++)
			{
				String str = s.substring(i,j+1);
				if(!trieImplementation.search(str))
				{
					trieImplementation.insert(str);
				}
			}
		}
		// this plus one is for the empty substring
		return trieImplementation.wordCount + 1;
	}
}
