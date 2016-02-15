package array;

/** XOR of all elements gives us odd occurring element. 
 * Please note that XOR of two elements 
 * is 0 if both elements are same 
 * and 
 * XOR of a number x with 0 is x.
 * */

public class OddOccurence {

	public static int oddOccurenceElement(int[] arr){
		int res=0;
		for(int i = 0;i< arr.length;i++)
			res = res ^ arr[i];
		
		
		return res;
	}
	
	public static void main(String[] args) {

		 int arr[] = {1, 2, 3, 2, 3, 3, 1};
		 System.out.print("Odd Occurence Element is: ");
		 System.out.println(oddOccurenceElement(arr));
	}

}
