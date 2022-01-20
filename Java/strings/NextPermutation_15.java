package strings;

import java.util.Arrays;

public class NextPermutation_15 {
	
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 6, 5, 4};
		int arr1[] = {1, 2, 3, 6, 7, 4};
		int arr2[] = {1, 2, 3, 6, 4, 5};
		
		nextPermutation(arr);
		nextPermutation(arr1);
		nextPermutation(arr2);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;// finding problem
		}
		if (i == -1) {// no problem found (sort the array and return)
			reverse(nums, 0, nums.length - 1);// reversing will sort the array because, no problem means that the array
												// is in descending order
			return;
		}

		int j = nums.length - 1;
		while (j > i && nums[j] <= nums[i]) {
			j--;// finding solution
		}

		swap(nums, i, j);// swapping problem with solution
		reverse(nums, i + 1, nums.length - 1);
	}

	static	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static	public void reverse(int[] arr, int i, int j) {
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
	}
}
