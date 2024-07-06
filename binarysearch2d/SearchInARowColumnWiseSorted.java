package binarysearch2d;

public class SearchInARowColumnWiseSorted {
	public boolean searchMatrix(int[][] matrix, int target) {
        int rlength = matrix.length;
        int clength = matrix[0].length;
        int r=0,c=clength-1;
        while(r<rlength && c>=0)
        {
            int element = matrix[r][c];
            if(element==target)
                return true;
            else if(element>target)
                c--;
            else 
                r++;

        }
        return false;
    }
}
