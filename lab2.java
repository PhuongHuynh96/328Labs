package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lab2 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter a positive integer n:");
		int n = keyboard.nextInt();

		// creating n random integers from -7000 to 7000
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i]=(int) (Math.random() * ((7000 - (-7000)) + (-7000)));
		}

		int n2 = 10000;
		int[] array2 = new int[n2];

		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * ((7000 - (-7000)) + (-7000)));
		}
		//printing out the array with n random integers unsorted
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println("");
		ArrayList<Integer> yo=new ArrayList<Integer>();
		yo=quick_sort(a);
		
		//printing out sorted array 
		for(int i=0;i<yo.size();i++){
			System.out.print(yo.get(i)+" ");
		}
		
		//time calculations for quick sort 
		long quickStart = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			quick_sort(a);
		}
		System.out.println("");
		
		long quickEnd = System.nanoTime();
		System.out.println("Average run time for Quick Sort: " + ((quickStart + quickEnd) / 100) + " nanoseconds");

		//calculations for insertion sort 
		long insertStart = System.nanoTime();
		for (int i = 0; i < array2.length; i++) {
			insertion_sort(a);
		}
		long insertEnd = System.nanoTime();
		System.out.println("Average run time for Insertion Sort: " + ((insertStart + insertEnd) / 100) + " nanoseconds");
		System.out.println("Instructions ran in a second using Insertion Sort: ");

	}

	public static ArrayList<Integer> quick_sort(int[] a) {
		ArrayList<Integer> left = new ArrayList<Integer>();
		ArrayList<Integer> right = new ArrayList<Integer>();

		if (a.length <= 3) {
			insertion_sort(a);
			ArrayList<Integer> alist=new ArrayList<Integer>();
			for(int i=0;i<a.length;i++){
				alist.add(a[i]);
			}
          return alist;
		}

		else {
			
			//find the pivot
			int first = a[0];
			int last = a[a.length-1];
			int middle = a[(a.length-1) /2];
			int[] pivotArray= new int[3];
			pivotArray[0] = first;
			pivotArray[1] = last; 
			pivotArray[2] = middle;
			Arrays.sort(pivotArray);

			int p = pivotArray[1];
	//		System.out.println("Pivot: "+p);

			//smaller #s than pivot go to left, larger #s than pivot go to right
			for (int i = 0; i < a.length-1; i++) {
				if (a[i] < p) {
					left.add(a[i]);
				} else if (a[i] > p) {
					right.add(a[i]);
				} 
			}
			
			//convert arraylist left to be array left, so it can be recursively called
			int[] arrayleft=new int[left.size()];
			for(int i=0;i<left.size();i++){
				arrayleft[i]=left.get(i);
			}
			
			//convert arraylist right to be array right, so it can be recursively called 
			int[] arrayright=new int[right.size()];
			for(int i=0;i<right.size();i++){
				arrayright[i]=right.get(i);
			}

			//call quick sort on the left and right arrays
/*			System.out.print("Left: ");
			for (int i = 0; i <arrayleft.length; i++){
				System.out.print(" "+arrayleft[i]+" ");
			}*/
			left = quick_sort(arrayleft);
			
			//call quick sort on the left and right arrays
/*			System.out.print("\nRight: ");
			for (int i = 0; i <arrayright.length; i++){
				System.out.print(" "+arrayright[i]+" ");
			}*/
			right = quick_sort(arrayright);
			
			//combine back left, right, and pivot 
			ArrayList<Integer> combined  = new ArrayList<Integer>();
			combined.addAll(left);
			combined.add(p);
			combined.addAll(right);
			return combined;

		}
	}

	public static int[] insertion_sort(int[] a) {
		// compares current array element to the one next to it
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j >= 0; j--) {
				// if the next element is bigger than the current element,
				// switch the elements
				// if next element is not bigger, do nothing and continue
				// looking through the array
				if (a[j] > a[i]) {
					int temp = a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}
		}
		return a;
	}

}
