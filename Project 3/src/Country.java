//Zhenyu Wu, CSE 017
public class Country implements Comparable<Country> {
	//Variable member
	private String code;
	private String name;
	private double area;
	
	//Constructor
	public Country() {
		code = "";
		name = "";
		area = 0.0;
	}
	public Country(String c, String n, double a) {
		code = c;
		name = n;
		area = a;
	}
	
	//Method
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public int compareTo(Country c) {
		return getName().compareTo(c.getName());
	}
	public String toString() {
		String str = String.format("%-5s\t%-40s\t%-20.0f\n", code , name , area);
		return str;
	}
	
}
