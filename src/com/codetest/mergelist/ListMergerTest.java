package com.codetest.mergelist;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ListMergerTest {
	/**
	 * Tests nullness of the lists. Expects IllegalArgumentException to be thrown
	 */
	@Test(expected=java.lang.IllegalArgumentException.class)
	public void testNulls() {		
		new ListMerger(null, null);	
	}

	/**
	 * Tests emptiness of the lists. Expects returned list to have size 0.
	 */
	@Test
	public void testEmpty() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged = merger.merge();
		Assert.assertEquals("Merged list not empty for empty inputs", 0, merged.size());
	}
	
	/**
	 * Tests if one of the lists is empty.
	 */
	@Test
	public void testOneEmpty() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(1);
		l1.add(2);
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged = merger.merge();
		
		Assert.assertEquals("Merged list not same as non-empty list", l1, merged);
	}
	
	/**
	 * Tests both lists as non-empty sorted lists
	 */
	@Test
	public void testBothNonEmpty() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(1);
		l1.add(3);
		
		l2.add(2);
		l2.add(4);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(1);
		l3.add(2);
		l3.add(3);
		l3.add(4);
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged = merger.merge();
		
		Assert.assertEquals("Merged list not same as merger of two lists", l3, merged);
	}
	
	/**
	 * Tests all lists having negative numbers
	 */
	@Test
	public void testAllNegative() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(-3);
		l1.add(-1);
		
		l2.add(-4);
		l2.add(-2);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(-4);
		l3.add(-3);
		l3.add(-2);
		l3.add(-1);
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged = merger.merge();
		
		Assert.assertEquals("Merged list not same as merger of two lists", l3, merged);
	}
	
	/**
	 * Tests all numbers in all the lists being equal
	 */
	@Test
	public void testAllEqual() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(13);
		l1.add(13);
		
		l2.add(13);
		l2.add(13);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(13);
		l3.add(13);
		l3.add(13);
		l3.add(13);
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged = merger.merge();
		
		Assert.assertEquals("Merged list not same as merger of two lists", l3, merged);
	}
	
	/**
	 * Tests calling of merge() twice since we have optimized it for multiple calls.
	 */
	@Test
	public void testMergeTwice() {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		l1.add(1);
		l1.add(13);
		
		l2.add(-2);
		l2.add(130);
		
		List<Integer> l3 = new ArrayList<>();
		l3.add(-2);
		l3.add(1);
		l3.add(13);
		l3.add(130);
		
		ListMerger merger = new ListMerger(l1, l2);
		List<Integer> merged1 = merger.merge();
		List<Integer> merged2 = merger.merge();
		
		Assert.assertEquals("Merged list not same as merger of two lists", l3, merged1);
		Assert.assertEquals("Merged list not same as merger of two lists", l3, merged2);
	}
}
