import java.util.ArrayList;

//Zhenyu Wu, CSE 017
public class Heap <E extends Comparable<E>> {
	private ArrayList<E> list;
	
	//Constructor
	public Heap() {
		list = new ArrayList<>();
	}
	public Heap(E[]element) {
		list = new ArrayList<>();
		for(int i = 0 ; i < element.length; i++) {
			Sort.iteration[5]++;
			list.add(element[i]);
		}
	}
	public Heap(ArrayList <E> element) {
		list = new ArrayList<>();
		for(int i = 0; i < element.size(); i++) {
			list.add(element.get(i));
		}
	}
	
	//Method
	public void add(E item) {
		list.add(item);
		int currentIndex = list.size() - 1;
		while(currentIndex > 0) {
			Sort.iteration[5]++;
			int parentIndex = (currentIndex - 1) / 2;
			E current = list.get(currentIndex);
			E parent = list.get(parentIndex);
			if(current.compareTo(parent) > 0) {
				list.set(currentIndex, parent);
				list.set(parentIndex, current);
			}
			else {
				break;
			}
			currentIndex = parentIndex;
		}
	}
	public E remove() {
		if(list.size() == 0) return null;
		E removedItem = list.get(0);
		list.set(0, list.get(list.size()-1));
		list.remove(list.size()-1);
		int currentIndex = 0;
		while (currentIndex < list.size()) {
			Sort.iteration[5]++;
			int left = 2 * currentIndex + 1;
			int right = 2 * currentIndex + 2;
			if (left >= list.size()) break;//reached the end
			int maxIndex = left;
			E max = list.get(maxIndex);
			if (right < list.size())
				if(max.compareTo(list.get(right)) < 0)
					maxIndex = right;
			E current = list.get(currentIndex);
			max = list.get(maxIndex);
			if(list.get(currentIndex).compareTo(max) < 0) {
				list.set(maxIndex, current);
				list.set(currentIndex, max);
				currentIndex = maxIndex;
			}
			else {
				break;
			}
		}
		return removedItem;
	}
	public int size() {
		return list.size();
	}
	public boolean isEmpty() {
		return list.isEmpty();
	}
	public void clear() {
		list.clear();
	}
	
}
