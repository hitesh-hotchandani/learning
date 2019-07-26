package org.ds.list;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListTest {

	private LinkedList<String> list;

	@BeforeMethod
	public void setUp() {
		list = new LinkedList<>();
	}


	@AfterMethod
	public void tearDown() {
	}

	@Test
	public void testInsert() {
		list.insert("Hello");
		list.insert("world");
		list.insert("Hitesh");
	}
}