package sorting;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 1, 2, 9, 11, 0, 7, 16, 3, 4, 8 };
		partition(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private static void partition(int[] arr, int low, int high) {
		if (low < high) {
			int mid = low + (high-low) / 2;
			partition(arr, low, mid);
			partition(arr, mid + 1, high);
			merge(arr, low, mid, high);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int[] left = new int[mid - low + 1];
		int[] right = new int[high - mid];

		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i + low];
		}

		for (int i = 0; i < right.length; i++) {
			right[i] = arr[i + mid + 1];
		}

		int i = 0;
		int j = 0;
		int k = low;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				arr[k++] = left[i++];
			else
				arr[k++] = right[j++];
		}
		while (i < left.length)
			arr[k++] = left[i++];
		while (j < right.length)
			arr[k++] = right[j++];

	}

}
