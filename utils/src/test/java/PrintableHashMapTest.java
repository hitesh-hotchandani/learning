import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class PrintableHashMapTest {

	private Map<Character, String> map;

	@BeforeMethod
	public void setUp() {
		map = new PrintableHashMap<>();
    /*map.put('a', "abcdef");
    map.put('b', "bcdef");
    map.put('c', "cdef");
    map.put('d', "def");
    map.put('e', "ef");
    map.put('f', "f");*/

	}

	@AfterMethod
	public void tearDown() {
		if (map != null) map.clear();
	}

	@Test
	public void testToString() {
		System.out.println(map);
	}
}