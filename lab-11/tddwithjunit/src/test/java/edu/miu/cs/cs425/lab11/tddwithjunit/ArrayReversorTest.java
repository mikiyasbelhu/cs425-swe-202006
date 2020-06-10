package edu.miu.cs.cs425.lab11.tddwithjunit;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayReversorTest {
	
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
		Integer[][] input = new Integer[][] {{1,3},{0},{4,5,9}};
		Integer[] expected = new Integer[] {9,5,4,0,3,1};
		
		when(flattenerService.flattenArray(input))
		.thenReturn(new Integer[] {1,3,0,4,5,9});
		
		Integer[] actual = arrayReversor.reverseArray(input);
		Assert.assertArrayEquals(expected, actual);
		
		verify(flattenerService).flattenArray(input);
	}

}
