package array;

public class LargestContiguousSubArray {

	public static int maxSubArraySum(int[] arr){
		
		int cur_max = arr[0];
		int max_so_far = arr[0];
		
		for(int i=1;i<arr.length;i++){
			
			cur_max = max(arr[i], cur_max+arr[i]);
			max_so_far = max(max_so_far, cur_max);
		}
		
		
		return max_so_far;
	}
	
	public static int max(int x, int y){
		return (x>y? x:y);
	}
	
	public static void main(String[] args) {

		int a[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(maxSubArraySum(a));
	}

}
