
public class Test {

	public static void main(String[] args) {
		
		Rational[][] A = {
				 {new Rational("1/2"),new Rational("1/2"),new Rational("1/2")},
				 {new Rational("1/2"),new Rational("1/2"),new Rational("1/2")},
				 {new Rational("1/2"),new Rational("1/2"),new Rational("1/2")}
				 };
				 // Creating rational matrices
				GenericMatrix<Rational> rationalMatrix1 = new GenericMatrix<>(A);
				GenericMatrix<Rational> rationalMatrix2 = new GenericMatrix<>(A);
				GenericMatrix<Rational> rationalMatrix3;
				 // Operations on rational matrices
				System.out.println("Rational Matrices");
				rationalMatrix3 = rationalMatrix1.add(rationalMatrix2);
				System.out.println("Addition");
				printMatrixOperation(rationalMatrix1, rationalMatrix2,
				 '+', rationalMatrix3);
				rationalMatrix3 = rationalMatrix1.subtract(rationalMatrix2);
				System.out.println("Subtraction");
				printMatrixOperation(rationalMatrix1, rationalMatrix2,
				 '-', rationalMatrix3);
				 rationalMatrix3 = rationalMatrix1.multiply(rationalMatrix2);
				System.out.println("Multiplication");
				printMatrixOperation(rationalMatrix1, rationalMatrix2,
				 '*', rationalMatrix3);
				
				Complex[][] AC = {
						{new Complex(1,2), new Complex(1,2), new Complex(1,2)},
						{new Complex(1,2), new Complex(1,2), new Complex(1,2)},
						{new Complex(1,2), new Complex(1,2), new Complex(1,2)}
						 };
						// Creating complex matrices
						GenericMatrix<Complex> complexMatrix1 = new GenericMatrix<>(AC);
						GenericMatrix<Complex> complexMatrix2 = new GenericMatrix<>(AC);
						GenericMatrix<Complex> complexMatrix3;
						 // Operations on complex matrices
						System.out.println("Complex Matrices");
						complexMatrix3 = complexMatrix1.add(complexMatrix2);
						System.out.println("Addition");
						printMatrixOperation(complexMatrix1, complexMatrix2,
						 '+', complexMatrix3);
						complexMatrix3 = complexMatrix1.subtract(complexMatrix2);
						System.out.println("Subtraction");
						printMatrixOperation(complexMatrix1, complexMatrix2,
						 '-', complexMatrix3);
						complexMatrix3 = complexMatrix1.multiply(complexMatrix2);
						System.out.println("Multiplication");
						printMatrixOperation(complexMatrix1, complexMatrix2,
						 '*', complexMatrix3);
						
	}
	public static <E extends Arithmetic<E>>
	 void printMatrixOperation(GenericMatrix<E> m1,
	 GenericMatrix<E> m2,
	 char operation,
	 GenericMatrix<E> result) {
		if(operation == '+') {
			for(int i = 0; i < m1.rows(); i++) {
				System.out.print("|" );
				for(int j = 0 ; j < m1.colums() ; j++) {
					System.out.print(m1.get(i, j).toString() + " " );
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("+  ");
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int k = 0; k < m2.colums(); k++) {
					System.out.print(m2.get(i, k).toString() + " ");
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("=  " );
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int n = 0 ; n < result.colums(); n++) {
					System.out.print(result.get(i, n).toString() + " ");
				}
				System.out.println("|");
			}
		}
		else if(operation == '-') {
			for(int i = 0; i < m1.rows(); i++) {
				System.out.print("|" );
				for(int j = 0 ; j < m1.colums() ; j++) {
					System.out.print(m1.get(i, j).toString() + " " );
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("-  ");
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int k = 0; k < m2.colums(); k++) {
					System.out.print(m2.get(i, k).toString() + " ");
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("=  " );
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int n = 0 ; n < result.colums(); n++) {
					System.out.print(result.get(i, n).toString() + " ");
				}
				System.out.println("|");
			}
		}
		else {
			for(int i = 0; i < m1.rows(); i++) {
				System.out.print("|" );
				for(int j = 0 ; j < m1.colums() ; j++) {
					System.out.print(m1.get(i, j).toString() + " " );
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("*  ");
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int k = 0; k < m2.colums(); k++) {
					System.out.print(m2.get(i, k).toString() + " ");
				}
				System.out.print("|" + "\t");
				if(i == 1) {
					System.out.print("=  " );
				}
				else {
					System.out.print("   ");
				}
				System.out.print("|" );
				for(int n = 0 ; n < result.colums(); n++) {
					System.out.print(result.get(i, n).toString() + " ");
				}
				System.out.println("|");
			}
		}
	}
	

}
