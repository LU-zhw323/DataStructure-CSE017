import java.util.ArrayList;
import java.util.Random;

//Zhenyu Wu, CSE 017
public class Testing {

	public static void main(String[] args) {
		Integer size = 10000;
		// Random List
		Random random = new Random();
		ArrayList<Integer> randomList = new ArrayList<>(size);
		for(int i = 0; i < size; i++) {
			randomList.add(random.nextInt(9999));
		}
		int [] RandomIteration = new int [6];
		Sort.selectionSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[0] = Sort.iteration[0];
		Sort.iteration[0] = 0;
		Sort.insertionSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[1] = Sort.iteration[1];
		Sort.iteration[1] = 0;
		Sort.bubbleSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[2] = Sort.iteration[2];
		Sort.iteration[2] = 0;
		Sort.mergeSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[3] = Sort.iteration[3];
		Sort.iteration[3] = 0;
		Sort.quickSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[4] = Sort.iteration[4];
		Sort.iteration[4] = 0;
		Sort.HeapSort(randomList);
		java.util.Collections.shuffle(randomList);
		RandomIteration[5] = Sort.iteration[5];
		Sort.iteration[5] = 0;
		
		//Sorted List
		ArrayList<Integer> SortedList = (ArrayList<Integer>) randomList.clone();
		java.util.Collections.sort(SortedList);
		int [] SortIteration = new int [6];
		Sort.selectionSort(SortedList);
		SortIteration[0] = Sort.iteration[0];
		Sort.iteration[0] = 0;
		Sort.insertionSort(SortedList);
		SortIteration[1] = Sort.iteration[1];
		Sort.iteration[1] = 0;
		Sort.bubbleSort(SortedList);
		SortIteration[2] = Sort.iteration[2];
		Sort.iteration[2] = 0;
		Sort.mergeSort(SortedList);
		SortIteration[3] = Sort.iteration[3];
		Sort.iteration[3] = 0;
		Sort.quickSort(SortedList);
		SortIteration[4] = Sort.iteration[4];
		Sort.iteration[4] = 0;
		Sort.HeapSort(SortedList);
		SortIteration[5] = Sort.iteration[5];
		Sort.iteration[5] = 0;
		
		//Reverse List
		int [] ReverseIteration = new int [6];
		ArrayList<Integer> ReverseList1 = (ArrayList<Integer>) SortedList.clone();
		java.util.Collections.reverse(ReverseList1);
		java.util.Collections.reverse(ReverseList1);
		ArrayList<Integer> ReverseList2 = (ArrayList<Integer>) ReverseList1.clone();
		ArrayList<Integer> ReverseList3 = (ArrayList<Integer>) ReverseList1.clone();
		ArrayList<Integer> ReverseList4 = (ArrayList<Integer>) ReverseList1.clone();
		ArrayList<Integer> ReverseList5 = (ArrayList<Integer>) ReverseList1.clone();
		ArrayList<Integer> ReverseList6 = (ArrayList<Integer>) ReverseList1.clone();
		Sort.selectionSort(ReverseList1);
		ReverseIteration[0] = Sort.iteration[0];
		Sort.insertionSort(ReverseList2);
		ReverseIteration[1] = Sort.iteration[1];
		Sort.bubbleSort(ReverseList3);
		ReverseIteration[2] = Sort.iteration[2];
		Sort.mergeSort(ReverseList4);
		ReverseIteration[3] = Sort.iteration[3];
		Sort.quickSort(ReverseList5);
		ReverseIteration[4] = Sort.iteration[4];
		Sort.HeapSort(ReverseList6);
		ReverseIteration[5] = Sort.iteration[5];
		
		
		System.out.println("Size: " + size);
		System.out.printf("%-30s\t%-30s\t%-30s\t%-30s\n", "Sorting Algorithm", "Random List", "Sorted List", "Reverse List");
		String [] Sorts = {"Selection Sort", "Insertion Sort", "Bubble Sort", "Merge Sort", "Quick Sort", "Heap Sort"};
		for(int i = 0 ; i < Sorts.length; i++) {
			System.out.printf("%-30s\t%-30d\t%-30d\t%-30d\n", Sorts[i], RandomIteration[i], SortIteration[i], ReverseIteration[i]);
		}
		/*
		 Selection Sort is the worst sorting algorithm dealing with three kinds of list, because it will go through the whole list for multiple times under any condition.
		 Insertion Sort and Bubble Sort are good choices dealing with sorted list, because the only thing they need to do is to check the list, but they are not good choices for both random and reverse
		 Quick sort is not a good choice for both sorted list and reverse sorted list, because it will waste too much time to check pivot index in a already-sorted list
		 Merge sort and heap sort are good choice for these three kinds of list
		 Merge sort keeps its iteration the same in any condition, because it will still split the list in any condition
		 Heap sort is efficient because of its completer binary tree structure
		 */

	}

}
