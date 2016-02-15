package array;

/** The ascending order sorted array is rotated 
 * at some pivot unknown to you beforehand 
 * 
 * To find the given key in the array, 
 * we first need to identify the pivot of array rotation.
 * 
 * To identify the pivot, find the element in the array whose
 * next element is smaller than it. That is the point of rotation.
 * 
 * Once the pivot is identified, the key should be searched
 * using Binary Search in either of the two sub arrays i.e
 * either to left of pivot or right of pivot.
 * */


public class SortedRotatedArray {

	public static int findPivot(int[] arr, int low, int high) {

		if (high < low)
			return -1;
		if (high == low)
			return low;
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		else if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		else if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);

		return findPivot(arr, mid + 1, high);
	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		int mid = 0;
		while (high >= low) {
			mid = (low + high) / 2;

			if (key == arr[mid])
				return mid;
			else if (key > arr[mid])
				low = mid + 1;
			else if (key < arr[mid])
				high = mid - 1;

		}
		return -1;
	}

	public static int findElement(int[] arr, int key) {

		int pivot = findPivot(arr, 0, arr.length - 1);
		if (pivot == -1)
			return binarySearch(arr, 0, arr.length - 1, key);

		if (arr[pivot] == key)
			return pivot;
		if (key < arr[0])
			return binarySearch(arr, pivot + 1, arr.length - 1, key);

		return binarySearch(arr, 0, pivot - 1, key);

	}

	public static void main(String[] args) {

		int arr[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int key = 7;

		System.out.println(key + " found at index : " + findElement(arr, key));
	}

}
