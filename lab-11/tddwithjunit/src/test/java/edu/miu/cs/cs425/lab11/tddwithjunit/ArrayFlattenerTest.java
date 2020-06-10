package edu.miu.cs.cs425.lab11.tddwithjunit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayFlattenerTest {
	
	private ArrayFlattener arrayFlattener = null;

	@Before
	public void setUp() throws Exception {
		arrayFlattener = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		arrayFlattener = null;
	}

	@Test
	public void testArrayFlattener() {
		Integer[][] input = {{1,3},{0},{4,5,9}};
		Integer[] expected = {1,3,0,4,5,9};
		Integer[] actual = arrayFlattener.flattenArray(input);
		Assert.assertArrayEquals(expected, actual);
	}

}
