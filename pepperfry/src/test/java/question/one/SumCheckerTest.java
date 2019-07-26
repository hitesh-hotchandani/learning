package question.one;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumCheckerTest {


	@Test
	public void testPerformTask() {
		String   s    = "1 2 3 4 5 6 7 8 9 10";
		int      sum  = 55;
		String[] data = s.split(" ");
		Assert.assertTrue(SumChecker.containsSubset(data, sum));
		sum = 56;
		Assert.assertFalse(SumChecker.containsSubset(data, sum));

		String default_usecase = "3 34 4 12 5 2";
		sum = 9;
		Assert.assertTrue(SumChecker.containsSubset(default_usecase.split(" "), sum));
	}
}