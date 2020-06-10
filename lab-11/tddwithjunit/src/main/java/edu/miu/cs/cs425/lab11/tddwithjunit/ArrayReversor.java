package edu.miu.cs.cs425.lab11.tddwithjunit;

import java.util.Arrays;
import java.util.Collections;

public class ArrayReversor {
	
	IArrayFlattenerService arrayFlattenerService;
	
	ArrayReversor(IArrayFlattenerService arrayFlattenerService){
		this.arrayFlattenerService = arrayFlattenerService;
	}
	
	public Integer[] reverseArray(Integer[][] array) {
		Integer[] flatArray = arrayFlattenerService.flattenArray(array);
		if(flatArray == null) {
			return null;
		}
		Collections.reverse(Arrays.asList(flatArray));
		return flatArray;
	}

}
