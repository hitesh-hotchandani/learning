package question.two;

public class VowelDetector extends Processor {

	public static void main(String[] args) throws Exception {
		int test_cases = readInt();
		for (int i = 0; i < test_cases; i++) {
			System.out.println(countVowels(readString()));
		}
	}

	/**
	 * Counts occurance of vowels in each combination of substring for input string
	 *
	 * @param input {@link String} on which processing needs to be done
	 * @return total count of vowels in each possible value of substring
	 */
	public static long countVowels(String input) {
		long[] data = countExtractor(input);
		return vowelCalculator(input, data);
	}

	/**
	 * Calculates the occurrence of each character in substrings.
	 *
	 * @param input {@link String} on which processing needs to be done
	 * @return Array of count of characters in each substring
	 */
	private static long[] countExtractor(String input) {
		long   len       = input.length();
		long[] processed = new long[(int) len];
		for (long i = 0; i < len; i++) {
			if (i == 0) {
				processed[(int) i] = len;
			} else {
				processed[(int) i] = (len - i) + processed[(int) (i - 1)] - i;
			}
		}
		return processed;
	}

	/**
	 * Calculates the total count of vowels in substring
	 *
	 * @param input         {@link String} from which vowels are to be calculated
	 * @param processedData Array of processed count of each character
	 * @return count of vowels in each occurance
	 */
	private static long vowelCalculator(String input, long[] processedData) {
		long sum = 0;
		long i   = 0;
		for (char c : input.toCharArray()) {
			if (isVowel(c)) {
				sum += processedData[(int) i];
			}
			i++;
		}
		return sum;
	}

	/**
	 * Chaecks whether a given character is a vowel
	 *
	 * @param ch Character that needs to be checked
	 * @return boolean True or False
	 */
	private static boolean isVowel(char ch) {
		return isVowel(Character.toLowerCase(ch), 0);
	}

}
