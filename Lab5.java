import java.util.ArrayList;
import java.util.Scanner;

public class Lab5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter an integer n");
		int n = in.nextInt();

		// creating n random integers from -100 to 100
		ArrayList<Integer> a = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			a.add((int) (Math.random() * ((10000 - (-10000) + 1) + (-10000))));

		}
		// displays unsorted array
		System.out.print("Unsorted array : ");
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + " ");
		}
		System.out.println("");
		
		heap_sort(a);
		
		// displays Sorted array
		System.out.print("Sorted array : ");
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + " ");
		}
		System.out.println("");
		
		//deleting the root node 
		int temp = a.get(0);
		a.set(0, a.size()-1);
		a.set(a.size()-1, temp);
		a.remove(a.get(a.size()-1));
		heap_sort(a);
		
		// displays Sorted array
		System.out.print("Sorted array with root node deleted: ");
		for (int i = 0; i < a.size(); i++) {

			System.out.print(a.get(i) + " ");
		}
		System.out.println("");
		
		// Average running time for heap sort function for n=10,000 and 100
		// repetitions

		// n = 10,000 for 100 repetitions
		long totalTime = 0;
		long startTime, endTime;
		int n2 = 10;
		for (int j = 0; j < 100; j++) {
			ArrayList<Integer> array2 = new ArrayList<Integer>();

			for (int i = 0; i < n2; i++) {
				array2.add((int) (Math.random() * ((10000 - (-10000) + 1) + (-10000))));

			}
			startTime = System.nanoTime();
			heap_sort(array2);
			endTime = System.nanoTime();
			totalTime += endTime - startTime;
		}
		totalTime = totalTime / 100;
		System.out.println("\nAverage run time for Heap Sort: " + totalTime
				+ " nanoseconds");

	}

	public static void heap_sort(ArrayList<Integer> a) {
		build_MaxHeap(a);
		int n = a.size();
		for (int i = n/2; i > 1; i--) {
			max_heapify(a, i);
		}

	}

	public static void build_MaxHeap(ArrayList<Integer> a) {
			max_heapify(a, a.get(0));
		
	}

	public static void max_heapify(ArrayList<Integer> a, int i) {
		int max_index = i;
		int left_index = (2 * i) ;
		int right_index = (2 * i) + 1;

		// if i has a left child and left child value is greater than i
		if ((left_index < a.size()) && (a.get(left_index) > a.get(max_index))) {
			max_index = left_index;
		}
		// if i has a right child and right child's value is greater than i
		// value
		if ((right_index < a.size()) && (a.get(right_index) > a.get(max_index))) {
			max_index = right_index;
		}
		// swap A[max_index] <--> A[i]
		if (max_index != i) {
			int temp = a.get(i);
			a.set(i, max_index);
			a.set(max_index, temp);
			max_heapify(a, max_index);
		}

	}

}
