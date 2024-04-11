//Zhenyu Wu, CSE 017
public abstract class Shape implements Comparable<Shape>, Cloneable, Scalable {
	//Variable
	private String color;
	
	//Constructor
	public Shape() {
		color = "none";
	}
	public Shape(String color) {
		this.color = color;
	}
	
	//method
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	public String toString() {
		return color;
	}
	public int compareTo(Shape s) {
		if(getArea()== s.getArea()) {
			return 0;
		}
		else if(getArea() < s.getArea()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract Object clone();
		
	
	
}
