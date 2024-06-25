package bitmanipulationhard;

public class OneNumberAppearingLessThanKTimes {
	public static void main(String[] args) {
		int[] arr= {1,1,2,2,2,3,3,3};
		int k =3;
		
		int[] count = new int[32];
		for(int i:arr)
		{
			for(int j=0;j<32;j++)
			{
				if((i&(1<<j))!=0)
					count[j]++;
			}
		}
		
		int res =0;
		for(int i=0;i<32;i++)
			res^=count[i]%k;
		//Now we will check for the number as it can be present less than k but more than 1
		// so we will divide the number by res/(n%k)
		// as 1 is appearing two times 2 would be present in res 2/(8%3)=2/2=1
		System.out.println(res/(arr.length%k));
		
	}
}
