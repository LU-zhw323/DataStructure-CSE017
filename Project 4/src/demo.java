import java.util.ArrayList;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(10);
		for(int i = 1 ; i < 11; i++) {
			list.add(i);
		}
		
		ArrayList<Integer> firstHalf = subList(list, 0 , list.size()/2);
		ArrayList<Integer> secondHalf = subList(list, list.size()/2, list.size());
		//System.out.println(list.get(list.size()/2));
		
		for(int i = 0; i < firstHalf.size(); i++) {
			System.out.print(firstHalf.get(i));
		}
		for(int i = 0; i < secondHalf.size(); i++) {
			System.out.print(secondHalf.get(i));
		}
		int s1 = Sort.iteration[0];
		
		
	}
	public static<E> ArrayList<E> subList(ArrayList<E>list, int start, int end){
		ArrayList<E> sublist = new ArrayList<>();
		for(int i = start; i <= end - 1; i ++) {
			sublist.add(list.get(i));
		}
		return sublist;
		
	}
}
