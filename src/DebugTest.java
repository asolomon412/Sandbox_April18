
public class DebugTest {

	public static void main(String[] args) {
//		int[] arr1 = { 1, 4, 5, 6, 7 };
//
//		for (int i = 0; i <= arr1.length; i++) {
//			System.out.println(arr1[i]);
//		}
		
		int iteration = 0;
		int mystery = 0;
		
		while (iteration < 100) {
			mystery = calculate(iteration,mystery);
			mystery = getNestedResult(iteration, mystery);
			iteration++;
		}

	}

	private static int calculate(int iteration, int mystery) {
		mystery += 3 * Math.pow(iteration, 2) + (iteration % 7);

		return mystery;
	}

	private static int getNestedResult(int iteration, int mystery) {
		if (mystery < iteration * 10)
			if (iteration > 20)
				if (mystery - mystery > 1000)
					mystery = 0;
				else
					mystery--;
			else
				mystery++;
		else
			mystery *= 2;

		return mystery;
	}

}
