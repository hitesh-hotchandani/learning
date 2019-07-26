package question.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Processor {

	private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * vowels
	 */
	private final static char[] vowel_weight = {'a', 'e', 'i', 'o', 'u'};

	/**
	 * Recursive function to check if the character is a vowel
	 *
	 * @param ch    {@link Character} that needs to be checked
	 * @param index index of the vowel_weight
	 * @return boolean True or False
	 */
	static boolean isVowel(char ch, int index) {
		try {
			if (index > vowel_weight.length) return false;
			if (ch == vowel_weight[index]) {
				return true;
			}
			if (ch < vowel_weight[index]) return false;

		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		return isVowel(ch, ++index);
	}

	/**
	 * Reads integer from command line
	 *
	 * @return Integer from command line
	 * @throws IOException In case input is not integer
	 */
	static int readInt() throws IOException {
		return Integer.parseInt(readString().trim());
	}

	/**
	 * Reads a string from command line
	 *
	 * @return String data from command line
	 * @throws IOException In cases of exception while reading data
	 */
	static String readString() throws IOException {
		return br.readLine();
	}
}
