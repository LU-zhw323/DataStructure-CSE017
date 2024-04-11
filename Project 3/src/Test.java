import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//Zhenyu WU, CSE 017
public class Test {
	
	static int[][] performance_insert = new int[2][228];
	static int[][] performance_search = new int[2][10];
	static int[][] performance_delete = new int[2][10];
	public static void main(String[] args) {
		ArrayList<Country>countryList = new ArrayList<>();
		
		//Read file
		File file = new File("countries.txt");
		try {
			Scanner fileReader = new Scanner(file);
			if(!file.exists()) {
				throw new FileNotFoundException("File not found");
			}//to determine whether the file is found
			else {
				while(fileReader.hasNext()) {
					String line = fileReader.nextLine();
					String [] Line = line.split("\\|");
					String code = Line[0];
					String name = Line[1];
					double area = Double.parseDouble(Line[2]);
					Country element = new Country(code , name , area);
					countryList.add(element);
				}	
			}
			fileReader.close();
		}
		catch(FileNotFoundException f) {
			System.out.println(f.getMessage());
		}
		
		BST<Country> countryBST = new BST<>();
		int insertCount = 0;
		for(int i = 0; i < countryList.size(); i++) {
			insertCount = countryBST.insert(countryList.get(i));
			performance_insert[0][i] = insertCount;
		}
		System.out.println("Sorted Country List");
		System.out.printf("%-5s\t%-40s\t%-20s\n", "Code", "Name", "Area(sq.Km)");
		countryBST.inorder();
		System.out.println(" ");
		System.out.println("Number of Leaf Node: " + countryBST.leafNode());
		System.out.println("Height of tree: " + countryBST.height());
		System.out.println("Is the tree balanced? " + countryBST.isBalanced());
		
		Random random = new Random();
		for(int i = 0; i < 10; i ++) {
			int randomNum = random.nextInt(countryList.size()-1);
			Country target = countryList.get(randomNum);
			int searchCount = countryBST.search(target);
			performance_search[0][i] = searchCount;
			int deleteCount = countryBST.delete(target);
			performance_delete[0][i] = deleteCount;
		}
		
		countryBST.clear();
		java.util.Collections.shuffle(countryList);
		int shuffledInsert = 0;
		for(int i = 0; i < countryList.size(); i++) {
			shuffledInsert = countryBST.insert(countryList.get(i));
			performance_insert[1][i] = shuffledInsert;
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Shuffeld Country List");
		System.out.printf("%-5s\t%-40s\t%-20s\n", "Code", "Name", "Area(sq.Km)");
		countryBST.inorder();
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Number of Leaf Node: " + countryBST.leafNode());
		System.out.println("Height of tree: " + countryBST.height());
		System.out.println("Is the tree balanced? " + countryBST.isBalanced());
		for(int i = 0; i < 10; i ++) {
			int randomNum = random.nextInt(countryList.size()-1);
			Country target = countryList.get(randomNum);
			int searchCount = countryBST.search(target);
			performance_search[1][i] = searchCount;
			int deleteCount = countryBST.delete(target);
			performance_delete[1][i] = deleteCount;
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.printf("%-40s\t%-40s\n", "Sorted List", "Shuffled List");
		System.out.printf("%-10s\t%-10s\t%-20s\t%-10s\t%-10s\t%-20s\n", "Insert", "Search", "Delete","Insert", "Search", "Delete" );
		for(int i = 0; i < 10; i++) {
			System.out.printf("%-10d\t%-10d\t%-20d\t%-10d\t%-10d\t%-20d\n", performance_insert[0][i], performance_search[0][i], performance_delete[0][i], performance_insert[1][i], performance_search[1][i], performance_delete[1][i]);
		}
		//after shuffling, the search and delete interation decreases, because elements in the coutryList will be saved in the BST based on its structure after sorting
		
	}

}
