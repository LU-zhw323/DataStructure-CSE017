import java.util.ArrayList;

//Zhenyu Wu, CSE 017
public class Sort {
	public static int [] iteration = new int [6];
	
	//Selection sort
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
		int minIndex;
		for(int i = 0; i < list.size()-1 ; i++) {
			iteration[0] ++;
			
			E min = list.get(i);
			minIndex = i;
			for(int j = i; j < list.size(); j++) {
				iteration[0] ++;
				if(list.get(i).compareTo(min)<0) {
					min = list.get(i);
					minIndex = j;
				}
			}
			E temp = list.get(i);
			list.set(i, list.get(minIndex));
			list.set(minIndex, temp);
			
		}
	}
	
	//Insertion sort
	public static <E extends Comparable<E>> void insertionSort(ArrayList<E>list) {
		for(int i = 0 ; i < list.size(); i ++) {
			iteration[1] ++;
			E current = list.get(i);
			int j = i;
			while(j > 0 && current.compareTo(list.get(j-1))<0){
				iteration[1]++;
				list.set(j, list.get(j-1));
				j--;
			}
			list.set(j, current);
		}
	}
	
	//Bubble sort
	public static <E extends Comparable<E>>void bubbleSort(ArrayList<E>list) {
		boolean sorted = false;
		for(int i = 1; i < list.size() && !sorted; i++) {
			iteration[2]++;
			sorted = true;
			for(int j = 0; j < list.size() - i; j++) {
				iteration[2]++;
				if(list.get(j).compareTo(list.get(j+1)) > 0) {
					E temp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, temp);
					sorted = false;
				}
			}
		}
	}
	
	//Merge sort
	public static <E extends Comparable<E>>void mergeSort(ArrayList<E>list) {
		iteration[3]++;
		if (list.size() > 1) { // base case
			ArrayList<E> firstHalf = subList(list, 0 , list.size()/2);
			ArrayList<E> secondHalf = subList(list, list.size()/2, list.size());
			mergeSort(firstHalf);
			mergeSort(secondHalf);
			merge(firstHalf, secondHalf, list);
		 }
	}
	public static<E> ArrayList<E> subList(ArrayList<E>list, int start, int end){
		ArrayList<E> sublist = new ArrayList<>();
		for(int i = start; i <= end - 1; i ++) {
			sublist.add(list.get(i));
		}
		return sublist;
		
	}
	
	public static <E extends Comparable<E>>void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
		int list1Index = 0;
		int list2Index = 0;
		int listIndex = 0;
		while( list1Index < list1.size() && list2Index < list2.size()) {
			iteration[3]++;
			if (list1.get(list1Index).compareTo(list2.get(list2Index))<0) {
				list.set(listIndex++, list1.get(list1Index++));
			}
			else {
				list.set(listIndex++, list2.get(list2Index++));
			}
		}
		while(list1Index < list1.size()) {
			iteration[3]++;
			list.set(listIndex++, list1.get(list1Index++));
		}
		while(list2Index < list2.size()) {
			iteration[3]++;
			list.set(listIndex++, list2.get(list2Index++));
		}
	}
	
	//Quick sort
	public static<E extends Comparable<E>> void quickSort(ArrayList<E>list) {
		quickSort(list, 0, list.size()-1);
	}
	public static <E extends Comparable<E>>void quickSort(ArrayList<E>list, int first, int last) {
		iteration[4]++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex+1, last);
		}
	}
	public static <E extends Comparable<E>>int partition(ArrayList<E>list, int first, int last){
		E pivot;
		int index, pivotIndex;
		pivot = list.get(first);// pivot is the first element
		pivotIndex = first;
		for (index = first + 1; index <= last; index++) {
			iteration[4]++;
			if (list.get(index).compareTo(pivot)<0){
				E temp = list.get(pivotIndex);
				list.set(pivotIndex, list.get(index));
				list.set(index, temp);
				pivotIndex++;
			}
		}
		E temp = list.get(first);
		list.set(first, list.get(pivotIndex));
		list.set(pivotIndex, temp);
		return pivotIndex;
	}
	
	//Heap sort
	public static < E extends Comparable<E>> void HeapSort(ArrayList<E>list) {
		Heap <E> heap = new Heap<>(list);
		for(int i = 0; i < list.size(); i ++) {
			iteration[5]++;
			list.set(i, heap.remove());
		}
	}
}
