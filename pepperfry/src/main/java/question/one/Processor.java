package question.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Processor {

	static final         String         FALSE = "False";
	static final         String         TRUE  = "True";
	private static final BufferedReader br    = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Converts {@link Set} to array of integer
	 *
	 * @param set {@link Set} that needs to be converted
	 * @return Array of integers
	 */
	private static int[] convertSetToIntArr(Set<Integer> set) {
		int[] arr = new int[set.size()];
		int   i   = 0;
		for (int x : set) {
			arr[i++] = x;
		}
		return arr;
	}

	/**
	 * Converts String input array to Set of Integer
	 *
	 * @param data Input Array
	 * @param sum  Upper threshold data value
	 * @return Set of Integer containing data within the threshold
	 */
	private static Set<Integer> convertStringArrToSet(String[] data, int sum) {
		Set<Integer> input_set = new HashSet<>();
		for (String s : data) {
			int x = getInt(s);
			if (x < sum) {
				input_set.add(x);
			}
		}
		return input_set;
	}

	/**
	 * Converts String to Integer
	 *
	 * @param input String that needs to be converted
	 * @return Integer value
	 * @throws NumberFormatException if the input string does not corresponds to a number
	 */
	private static int getInt(String input) {
		return Integer.parseInt(input.trim());
	}

	/**
	 * Converts String Array to {@link Set} of Integers. Also, removes numbers greater than sum value
	 *
	 * @param data String Input Array
	 * @param sum  Upper Threshold
	 * @return A Set of Integers
	 */
	static int[] processInput(String[] data, int sum) {
		return convertSetToIntArr(convertStringArrToSet(data, sum));
	}

	static String[] readStringArray() throws IOException {
		return br.readLine().split(" ");
	}

	static int readInteger() throws IOException {
		return getInt(br.readLine());
	}
}
