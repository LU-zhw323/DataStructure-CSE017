
public class demo {

	public static void main(String[] args) {
		String a = "B-111-111-111";
		if(a.matches("B-\\d{3}-\\d{3}-\\d{3}")) {
			System.out.println("1");
		}
		else {
			System.out.println(2);
		}
		int i = 2;
		int j = 7;
		int z = i - j;
		System.out.println(z);
				

	}

}
