//Zhenyu WU, CSE 017
public class Complex implements Arithmetic<Complex>{
	//Variable
	private int real;
	private int imaginary;
	
	//Constructor
	public Complex() {
		real = 0;
		imaginary = 0;
	}
	public Complex(int r, int i) {
		real = r;
		imaginary = i;
	}
	
	//method
	public Complex add(Complex c) {
		int Rnum = real + c.real;
		int Inum = imaginary + c.imaginary;
		Complex result = new Complex(Rnum, Inum);
		return result;
	}
	public Complex subtract(Complex c) {
		int Rnum = real - c.real;
		int Inum = imaginary - c.imaginary;
		Complex result = new Complex(Rnum, Inum);
		return result;
	}
	public Complex multiply(Complex c) {
		int Rnum = real*c.real - imaginary * c.imaginary;
		int Inum = real * c.imaginary + imaginary * c.real;
		Complex result = new Complex(Rnum, Inum);
		return result;
	}
	public Complex divide(Complex c) {
		int Rnum = real*c.real - imaginary * c.imaginary;
		int Inum = real * c.imaginary + imaginary * c.real;
		Complex result = new Complex(Rnum, Inum);
		return result;
	}
	public String toString() {
		if(real == 0 && imaginary != 0) {
			return imaginary + "i";
		}
		else if(imaginary == 0 && real != 0) {
			return Integer.toString(real);
		}
		else if(imaginary == 1) {
			return real + " + i";
		}
		else if(real == 0 && imaginary == 0) {
			return "0";
		}
		else {
			return real + " + " + imaginary + "i";
		}
	}
}
