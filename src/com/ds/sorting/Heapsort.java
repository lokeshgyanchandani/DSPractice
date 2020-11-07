package sorting;

public class Heapsort {

	public static void main(String[] args) {
		int array[] = { 11, 10, 5, 2, 56, 0, 46, 7, 1, 3, 4 };
		int size = array.length - 1;
		heapsort(array, size);
	}

	private static void heapsort(int[] array, int size) {
		buildMaxHeap(array, size);
		for (int i = size; i >= 0; i--) {
			System.out.println(array[0]);
			swap(array,0,i);
			size = size-1;
			buildMaxHeap(array ,size);
		}
	}

	private static void buildMaxHeap(int[] array, int size) {
		for (int i = size / 2; i >= 0; i--) {
			maxheap(array, i, size);
		}
	}

	private static void maxheap(int[] array, int parent, int size) {
		int max = parent;
		int left = 2 * parent ;
		int right = 2 * parent + 1;
		if (left < size && array[left] > array[parent])
			max = left;
		if (right < size && array[right] > array[parent])
			max = right;
		if (max != parent) {
			swap(array, max, parent);
			maxheap(array, max, size);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];

		arr[i] = arr[j];

		arr[j] = tmp;
	}
}
