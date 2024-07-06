package binarysearch2d;

public class MatrixWithMaximum1s {
	int rowWithMax1s(int arr[][], int n, int m) {
        int maxRow = -1;
        int r=0, rlength = arr.length;
        int clength=arr[0].length,c=clength-1;
        while(r<rlength && c>=0)
        {
            if(arr[r][c]==1)
            {
                maxRow = r;
                c--;
            }
            else
                r++;
        }
        return maxRow;
    }
}
