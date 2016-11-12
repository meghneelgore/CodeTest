package com.codetest.threeproduct;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Class to find the greatest product of 3 numbers from a provided list of numbers.
 * @author meghneel.gore
 *
 */
public class ThreeProduct {
	private final List<Integer> list;
	private Integer product;
	
	/**
	 * Constructor. Creates an object with a defensively copied list.
	 * 
	 * @param list List of at least 3 integers
	 * @throws IllegalArgumentException if the list is null or contains less than 3 elements
	 */
	public ThreeProduct(List<Integer> list) {
		if(list == null) throw new IllegalArgumentException("List of integers is null");
		if(list.size() < 3) throw new IllegalArgumentException("List needs to have at least 3 integers");
		this.list = ImmutableList.copyOf(list); //Defensive copy
	}

	/**
	 * Finds the greatest product of any 3 numbers from the list of given numbers. 
	 * Optimizes for time. Worst case run time is O(N) where N is the length of the given list
	 * 
	 * Note: If the size of the list were to be known, we could also sort the list first and then it'd be a trivial 
	 * exercise to find the top 3 and bottom 2 numbers. This would enhance readability of the code manifold and should
	 * definitely be considered when making a decision as to whether to use the following algorithm or not. The following
	 * algorithm is not very readable.

	 * @return Greatest product of any 3 numbers from the list.
	 */
	public synchronized int findProduct() {
		if(product != null) return product.intValue();
		//The max product can only be a product of the 3 max or the 1st max and 2 min numbers
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		//Start of code that's not very readable. It basically finds the max, second-max, third-max, min and second-min
		//values in the list.
		for(Integer i: list) {
			if(max1 < i) {
				int intermediateMax1 = max1;
				max1 = i;
				if(max2 < intermediateMax1) {
					int intermediateMax2 = max2;
					max2 = intermediateMax1;
					if(max3 < intermediateMax2) {
						max3 = intermediateMax2;
					}
				} else if(max3 < intermediateMax1) {
					max3 = intermediateMax1;
				}
			} else if(max2 < i) {
				int intermediateMax2 = max2;
				max2 = i;
				if(max3 < intermediateMax2) {
					max3 = intermediateMax2;
				}
			} else if(max3 < i) {
				max3 = i;
			}
			if(min1 > i) {
				int intermediateMin = min1;
				min1 = i;
				if(min2 > intermediateMin) {
					min2 = intermediateMin;
				}
			} else if(min2 > i) {
				min2 = i;
			}
		}
		//End of unreadable code
		
		
		//If the product overflows a 32-bit signed int, throw IllegalArgumentException
		long prod1 = (long)min1 * (long)min2 * (long)max1;
		if(prod1 > Integer.MAX_VALUE || prod1 < Integer.MIN_VALUE)  throw new IllegalArgumentException("Product cannot fit in 32 bit signed integer");
		long prod2 = (long)max1 * (long)max2 * (long)max3;
		if(prod2 > Integer.MAX_VALUE || prod2 < Integer.MIN_VALUE) throw new IllegalArgumentException("Product cannot fit in 32 bit signed integer");
		product = (int)Math.max(prod1, prod2);
		return product.intValue();
		
	}
}
