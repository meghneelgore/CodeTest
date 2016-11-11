package com.codetest.mergelist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Class to merge two lists of integers.
 * 
 * @author meghneel.gore
 */
public class ListMerger {

	private final List<Integer> list1; 
	private final List<Integer> list2;

	private List<Integer> returnList;
	
	/**
	 * Constructor. Initializes the ListMerger class with immutable copies of the provided two lists of Integers.
	 * Assumes the lists provided are sorted.
	 * 
	 * @param l1 First list
	 * @param l2 Second list
	 * @throws IllegalArgumentException if any of the above lists is null
	 * 
	 */
	public ListMerger(List<Integer> l1, List<Integer> l2) {
		if(l1 == null || l2 == null) throw new IllegalArgumentException("One or both lists is/are null");
		list1 = new ArrayList<>(l1); //Defensive copy
		list2 = new ArrayList<>(l2); //Defensive copy	
	}
	
	/**
	 * Merges the two lists of integers specified in the constructor. Worst case run time is O(N) where N is the 
	 * number of elements in both the lists.
	 * 
	 * @return Merged list with duplicates. The returned list will be of size 0 if both the lists are of size 0.
	 */
	public List<Integer> merge() {
		//If merge was done before, return without any processing
		if(returnList != null) return returnList;

		if(list1.size() == 0 && list2.size() == 0) return ImmutableList.of(); //Always better to return an empty list than null
		if(list1.size() == 0) return list2;
		if(list2.size() == 0) return list1;
		
		returnList = new ArrayList<>();
		while(true) {
			//If one list is empty, append the other list and return the merged list
			if(list1.size() == 0) {
				returnList.addAll(list2);
				//Save returnList as immutable copy so that if merge is called again, we can return it directly
				returnList = ImmutableList.copyOf(returnList); 
				return ImmutableList.copyOf(returnList);
			}
			//If one list is empty, append the other list and return the merged list
			if(list2.size() == 0) {
				returnList.addAll(list1);
				//Save returnList as immutable copy so that if merge is called again, we can return it directly
				returnList = ImmutableList.copyOf(returnList); 
				return ImmutableList.copyOf(returnList);
			}
			if(list1.get(0) < list2.get(0)){
				returnList.add(list1.remove(0));
			} else {
				returnList.add(list2.remove(0));
			}
		}
		

	}
}
