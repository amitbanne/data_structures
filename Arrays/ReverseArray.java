package array;

public class ReverseArray {

	public static int[] reverseArray(int[] arr){
		int i =0, j =arr.length-1;
		while(i<j){
			int t = arr[i];
			arr[i] =arr[j];
			arr[j] = t;
			
			i++;
			j--;
		}
		
		return arr;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {1,2,3,4,5};
		arr = reverseArray(arr);
		System.out.println("Reversed Array");
		for(int i: arr)
			System.out.print(i+" ");
	}

}
