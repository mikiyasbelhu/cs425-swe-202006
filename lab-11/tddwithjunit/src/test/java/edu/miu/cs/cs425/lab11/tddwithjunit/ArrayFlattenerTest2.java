package edu.miu.cs.cs425.lab11.tddwithjunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerTest2 {
	
	private ArrayFlattener arrayFlattener = null;

	@Before
	public void setUp() throws Exception {
		arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testArrayFlattenerEmptyInput() {
		Integer[][] input = null;
		Integer[] expected = null;
		Integer[] actual = arrayFlattener.flattenArray(input);
		Assert.assertArrayEquals(expected, actual);
	}

}
