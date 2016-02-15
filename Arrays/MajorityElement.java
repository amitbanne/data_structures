package array;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This is a two step process. 1. Get an element occurring most of the time in
 * the array. This phase will make sure that if there is a majority element then
 * it will return that only. 2. Check if the element obtained from above step is
 * majority element.
 * 
 * */

public class MajorityElement {

	/*
	 * majorityElement (arr[])
	 * 
	 * 1. Find the candidate for majority 2. If candidate is majority. i.e.,
	 * appears more than n/2 times. Print the candidate 3. Else Print "NONE"
	 */

	public static void majorityElement(int[] arr) {

		int candidate = findCandidate(arr);
		isMajority(arr, candidate);

	}

	/*
	 * findCandidate(arr[]) 1. Initialize index and count of majority element
	 * maj_index = 0, count = 1
	 * 
	 * 2. Loop for i = 1 to size – 1 (a)If a[maj_index] == a[i] count++ (b)Else
	 * count--; (c)If count == 0 maj_index = i; count = 1 3.
	 * 
	 * Return a[maj_index]
	 */

	public static int findCandidate(int[] arr) {

		int majority = 0, count = 1;
		for (int i = 1; i < arr.length; i++) {

			if (arr[majority] == arr[i])
				count++;
			else
				count--;

			if (count == 0) {
				majority = i;
				count = 1;
			}

		}

		return arr[majority];

	}

	public static void isMajority(int[] arr, int candidate) {

		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == candidate)
				n++;
		}

		if (n > (arr.length / 2))
			System.out.println("Majority Element: " + candidate);
		else
			System.out.println("No majority element found");

	}

	/* Finding majority element using hash map */

	public static void majorityUsingHash(int[] arr) {

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			/* If key is already present, increase the corresponding count value. 
			 * If key is not present, add the entry to map with count as 1
			 * 
			 * */
			if (map.keySet().contains(arr[i])) {
				int count = map.get(arr[i]);
				map.remove(arr[i]);
				map.put(arr[i], ++count);
			} else
				map.put(arr[i], 1);
		}

		Object[] keys = map.keySet().toArray();
		Object[] values = map.values().toArray();

		int max = 0;

		// find the index of max count in values set of map 
		for (int i = 0; i < values.length; i++) {
			if (((int) values[i]) > ((int) values[max]))
				max = i;
		}
		

		/* if count of max element is greater than half of length 
		 * of input array, majority element is found. */
		if (((int) values[max]) > (arr.length / 2))
			System.out.println("Majority element found: " + keys[max]);
		else
			System.out.println("No Majority element found");
	}

	public static void main(String[] args) {

		int[] arr = { 3, 2, 2, 5, 2, 2, 6 };
		majorityElement(arr);

		System.out.println("Using hashing");
		majorityUsingHash(arr);
	}

}
