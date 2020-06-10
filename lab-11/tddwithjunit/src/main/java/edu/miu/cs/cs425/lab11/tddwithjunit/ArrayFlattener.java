package edu.miu.cs.cs425.lab11.tddwithjunit;

import java.util.ArrayList;
import java.util.List;

public class ArrayFlattener {
	
	public Integer[] flattenArray(Integer[][] array) {
		if(array == null) {
			return null;
		}
		List<Integer> list = new ArrayList<>();
		for(Integer[] arr: array ) {
			for(Integer num: arr ) {
				list.add(num);
			}	
		}
		Integer[] flatArray = new Integer[list.size()];
		list.toArray(flatArray);
		return flatArray;
	}

}
