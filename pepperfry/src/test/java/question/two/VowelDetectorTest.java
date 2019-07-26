package question.two;

import org.testng.Assert;
import org.testng.annotations.Test;

public class VowelDetectorTest {

	@Test
	public void testCountVowels() {
		String input    = "baceb";
		int    expected = 16;
		Assert.assertEquals(expected, VowelDetector.countVowels(input));
	}
}