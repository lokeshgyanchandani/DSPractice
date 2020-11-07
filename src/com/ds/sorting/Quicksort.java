package sorting;

public class Quicksort {

	public static void main(String[] args) {

		int array[] = { 11, 10, 5, 2, 56, 0, 46, 7, 1, 3, 4 };
		int high = array.length - 1;
		quicksort(array, 0, high);
		for(int i :array)
		{
			System.out.println(i);
		}
	}

	private static void quicksort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = partition(array, low, high);
			quicksort(array, low, pivot - 1);
			quicksort(array, pivot + 1, high);
		}

	}

	private static int partition(int[] array, int low, int high) {
		int wall = low;
		int pivot = array[high];
		for (int i = low; i < high; i++) {
			if (array[i] < pivot) {
				int temp = array[i];
				array[i] = array[wall];
				array[wall] = temp;
				wall = wall + 1;
			}
		}
		int temp = array[high];
		array[high] = array[wall];
		array[wall] = temp;

		return wall;
	}
}
