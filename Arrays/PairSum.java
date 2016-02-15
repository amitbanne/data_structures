package array;

public class PairSum {

	static int MAX = 10000;
	
	public static int hasPairSum(int[] array, int sum){
		
		boolean[] barray = new boolean[MAX];
		
		for(int i=0;i<array.length;i++){
			int temp = sum - array[i];
			
			if(temp>0 && barray[temp]){
				System.out.println("Pair found: "+ temp+" and "+array[i]);
				return 1;
			}
			barray[array[i]] =true;
		}

		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = {1, 4, 45, 6, 10, 8};
        int n = 5;
        hasPairSum(arr, n);
		
	}

}
