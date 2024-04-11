//Zhenyu Wu, CSE 017
public class Pair <E1,E2> {
	//variable
	private E1 first;
	private E2 second;
	
	//Constructor
	public Pair(E1 first, E2 second) {
		this.first = first;
		this.second = second;
	}
	
	//method
	public E1 getFirst() {
		return first;
	}

	public void setFirst(E1 first) {
		this.first = first;
	}

	public E2 getSecond() {
		return second;
	}

	public void setSecond(E2 second) {
		this.second = second;
	}
	public String toString() {
		return  "(" + first.toString() + ", " +
				 second.toString() + ")";
	}
	public boolean equals(Object obj) {
		Pair<E1, E2> pair = (Pair<E1, E2>) obj;
		boolean eq = pair.getFirst().equals(first);
		eq = eq && pair.getSecond().equals(second);
		return eq;
		}
	
	
}
