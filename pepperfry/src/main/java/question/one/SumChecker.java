package question.one;

import java.io.IOException;

/**
 * Checks if input data contains subset which equals to sum.
 * Assumes that the data will be positive integers
 * <p>
 * <p>
 * NOTE:
 * Following class throws Exception in case of breach of input data contract.
 * Expected Input:
 * 1. Space separated positive integers
 * 2. Positive integers denoting sum that is to be found.
 * <p>
 * <p>
 * Utility functions can be found in the {@link Processor} class. Contents of this class are kept restricted to
 * demonstrate
 * the algorithm.
 */
public class SumChecker extends Processor {

	public static void main(String[] args) throws IOException {
		String found = FALSE;
		if (containsSubset(readStringArray(), readInteger())) {
			found = TRUE;
		}
		System.out.println(found);
	}

	/**
	 * Checks if the given input set contains subset which adds up to sum.
	 *
	 * @param input Array of {@link String} which contains positive non repetitive numbers
	 * @param sum   {@link Integer} which should equal to the sum of subset
	 * @return boolean TRUE or FALSE depending upon the existence of subset
	 */
	public static boolean containsSubset(String[] input, int sum) {
		int[] cleanData = processInput(input, sum);
		return checksum(cleanData, cleanData.length, sum);
	}


	/**
	 * Algorithm to check id the given data contains subset which on addition equals to required sum
	 *
	 * @param data  complete set of data
	 * @param index index of current iteration
	 * @param sum   Sum that needs to be found
	 * @return boolean true if subset is found else false
	 */
	private static boolean checksum(int[] data, int index, int sum) {
		if (sum == 0) {
			return true;
		}
		if (index == 0) {
			return false;
		}
		index--;
		if (data[index] > sum) {
			return checksum(data, index, sum);
		}

		return checksum(data, index, sum) || checksum(data, index, sum - data[index]);
	}

}