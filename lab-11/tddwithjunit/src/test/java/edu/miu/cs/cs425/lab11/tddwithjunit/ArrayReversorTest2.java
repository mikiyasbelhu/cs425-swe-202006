package edu.miu.cs.cs425.lab11.tddwithjunit;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayReversorTest2 {
	
	private ArrayReversor arrayReversor = null;
	private IArrayFlattenerService flattenerService= mock(IArrayFlattenerService.class);
	
	@Before
	public void setUp() throws Exception {
		arrayReversor = new ArrayReversor(flattenerService);
	}

	@After
	public void tearDown() throws Exception {
		arrayReversor = null;
	}

	@Test
	public void testReverseArray() {
		Integer[][] input = null;
		Integer[] expected = null;
		
		when(flattenerService.flattenArray(input))
		.thenReturn(null);
		
		Integer[] actual = arrayReversor.reverseArray(input);
		Assert.assertArrayEquals(expected, actual);
		
		verify(flattenerService).flattenArray(input);
	}

}
