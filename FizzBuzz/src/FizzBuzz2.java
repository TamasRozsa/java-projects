
public class FizzBuzz2 {

	public static void main(String[] args) {

		for (int i = 1; i <= 101; i++) {
			if (i % 15 == 0) {
				System.out.printf("%2d Osztható 15-tel%n", i);
			} else if (i % 3 == 0) {
				System.out.printf("%2d Osztható 3-mal%n", i);
			} else if (i % 5 == 0) {
				System.out.printf("%2d Osztható 5-tel%n", i);
			} else
				System.out.printf("%2d %n", i);
		}
	}

}