//Zhenyu WU, CSE 017
public class Rational implements Arithmetic<Rational>{
	//Variable
	private int numerator;
	private int denominator;
	
	//Constructor
	public Rational() {
		numerator = 0;
		denominator = 1;
	}
	public Rational(int n, int d) {
		numerator = n;
		denominator = d;
	}
	public Rational(String s) {
		//int index = s.indexOf("/");
		numerator = Integer.parseInt(s.substring(0,1));
		denominator = Integer.parseInt(s.substring(2 , s.length()));
	}
	
	//Method
	public Rational add(Rational f) {
		 int num = numerator * f.denominator + denominator * f.numerator;
		 int denum = denominator * f.denominator;
		 Rational result = new Rational (num, denum);
		 result.reduced();
		 return result;
	}
	public Rational subtract(Rational f) {
		int num = numerator * f.denominator - denominator * f.numerator;
		int denum = denominator * f.denominator;
		Rational result = new Rational(num , denum);
		result.reduced();
		return result;
	}
	public Rational multiply(Rational f) {
		int num = numerator * f.numerator;
		int denum = denominator * f.denominator;
		Rational result = new Rational(num, denum );
		result.reduced();
		return result;
	}
	public Rational divide(Rational f) {
		int num = numerator * f.denominator;
		int denum = denominator * f.numerator;
		Rational result = new Rational(num, denum);
		result.reduced();
		return result;
	}
	public String toString() {
		if(denominator == 1) {
			return Integer.toString(numerator);
		}
		else if(numerator == 0) {
			return Integer.toString(0);
		}
		else {
			return numerator + "/" + denominator;
		}
	}
	public int gcd(int d, int n) {
		if(d == 0 || n ==0) {
			return 1;
		}
		else {
			if(d%n == 0 ) {
				return n;
			}
			else {
				return gcd(n, d%n);
			}
		}
		
	}
	private void reduced() {
		int gcd = gcd(denominator, numerator);
		denominator = denominator / gcd;
		numerator = numerator / gcd;
	}
	
	
}
