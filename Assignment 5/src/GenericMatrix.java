//Zhenyu WU, CSE 017
import java.util.ArrayList;
public class GenericMatrix<E extends Arithmetic> {
	//Variable
	private ArrayList<ArrayList<E>> matrix;
	
	//Constructor
	public GenericMatrix(E[][]list) {
		matrix = new ArrayList<>();
		for(int i = 0 ; i < list.length ; i++) {
			ArrayList row = new ArrayList<>();
			for(int j = 0; j < list[i].length; j++) {
				row.add(list[i][j]);
			}
			matrix.add(row);
		}
	}
	public GenericMatrix(ArrayList<ArrayList<E>> list) {
		matrix = new ArrayList<>();
		for(int i = 0; i < list.size(); i ++) {
			ArrayList row = new ArrayList<>();
			for(int j = 0; j < list.get(i).size(); j ++) {
				row.add(list.get(i).get(j));
			}
			matrix.add(row);
		}
	}
	
	//Method
	public  E get(int r, int c) {
		return matrix.get(r).get(c);
	}
	public void set(int r, int c, E value) {
		matrix.get(r).set(c, value);
	}
	public int rows() {
		return matrix.size();
	}
	public int colums() {
		int colum = 0;
		for(int i = 0; i < matrix.size(); i ++) {
			colum += matrix.get(i).size();
		}
		return colum/3;
	}
	public GenericMatrix<E> add(GenericMatrix<E> gm){
		GenericMatrix<E> result = new GenericMatrix<>(matrix);
		for(int i = 0; i < gm.matrix.size(); i++) {
			for(int j = 0; j < gm.matrix.get(i).size(); j++) {
				result.set(i , j , (E)matrix.get(i).get(j).add(gm.matrix.get(i).get(j)));
			}
		}
		return result;
	}
	public GenericMatrix<E> subtract(GenericMatrix<E>gm){
		GenericMatrix<E> result = new GenericMatrix<>(matrix);
		for(int i = 0; i < gm.matrix.size(); i++) {
			for(int j = 0; j < gm.matrix.get(i).size(); j++) {
				result.set(i , j , (E)matrix.get(i).get(j).subtract(gm.matrix.get(i).get(j)));
			}
		}
		return result;
	}
	public GenericMatrix<E> multiply(GenericMatrix<E>gm){
		GenericMatrix<E> result = new GenericMatrix<>(matrix);
		for(int i = 0; i < matrix.size(); i++) {
			for(int j = 0; j < matrix.get(i).size(); j++) {
				E sum = (E)(matrix.get(i).get(0).multiply(gm.matrix.get(0).get(j)));
				for(int k = 1; k < matrix.get(i).size(); k++) {
					sum = (E) sum.add(matrix.get(i).get(k).multiply(gm.matrix.get(k).get(j)));
				}
				result.set(i, j, sum);
			}
		}
		return result;
	}
	
	
}
