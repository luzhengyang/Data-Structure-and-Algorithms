// Implement an iterator to flatten a 2d vector.

// For example,
// Given 2d vector =

// [
//   [1,2],
//   [3],
//   [4,5,6]
// ]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

import java.util.*;

public class Flatten2DVector{
	private int[] array;
	private int count;
	public Flatten2DVector(List<List<Integer>> vec2d){
		// initialize the array
		if(vec2d == null){
			array = new int[0];
		}

		int arraySize = 0;
		// get the size of array
		for(List<Integer> list : vec2d){
			if(list != null){
				arraySize += list.size();
			}
		}

		// fill the array
		int i = 0;
		for(List<Integer> list : vec2d){
			for(int num : list){
				array[i] = num;
				i++;
			}
		}

	}

	public boolean hasNext(){
		if(count < array.length){
			return true;
		}
		return false;
	}

	public int next(){
		int val = Integer.MIN_VALUE;
		if(count < array.length){
			val = array[count];
			count++;
		}
		return val;
	}
}
