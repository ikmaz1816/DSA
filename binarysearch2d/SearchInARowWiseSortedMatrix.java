package binarysearch2d;

public class SearchInARowWiseSortedMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {

        int rlength = matrix.length;
        int clength = matrix[0].length;
        if(matrix[rlength-1][clength-1]<target)
            return false;
        int start=0,end= rlength * clength -1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            int row = mid/clength;
            int col = mid%clength;
            int element = matrix[row][col];
            if(element==target)
                return true;
            else if(element>target)
                end = mid-1;
            else
                start=mid+1;
        }
        return false;
    }
}
