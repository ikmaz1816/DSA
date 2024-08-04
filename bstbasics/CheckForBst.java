package bstbasics;

public class CheckForBst {
	// we have been provided with a inorder traversal , we have to check for BST
	static boolean isBSTTraversal(int arr[]) {
        int length = arr.length;
        for(int i=0;i<length-1;i++)
        {
            if(arr[i]>=arr[i+1])
                return false;
        }
        return true;
    }
}
