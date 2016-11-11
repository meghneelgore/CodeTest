package com.codetest.threeproduct;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ThreeProductTest {

	/**
	 * Tests null list. Expects IllegalArgumentException to be thrown.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNull() {
		new ThreeProduct(null);
	}
	
	/**
	 * Tests that calling with a list having less than 3 elements throws an IllegalArgumentException
	 */
	@Test(expected=IllegalArgumentException.class) 
	public void testLessThanThreeNumbers() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		new ThreeProduct(list);
	}
	
	/**
	 * Tests for all positive numbers
	 */
	@Test
	public void testAllPositive() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		ThreeProduct p = new ThreeProduct(list);
		Assert.assertEquals("Product not correct", 18, p.findProduct());
	}

	/**
	 * Tests for all negative numbers
	 */
	@Test 
	public void testAllNegative() {
		List<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(-2);
		list.add(-3);
		list.add(-3);
		ThreeProduct p = new ThreeProduct(list);
		Assert.assertEquals("Product not correct", -6, p.findProduct());
	}
	
	/**
	 * Tests with positive and negative numbers
	 */
	@Test
	public void testMixed() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(-200);
		list.add(-300);
		list.add(3);
		ThreeProduct p = new ThreeProduct(list);
		Assert.assertEquals("Product not correct", 180000, p.findProduct());
	}
	
	/**
	 * Tests with positive and negative numbers with a larger list of numbers
	 */
	@Test
	public void testMixed2() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(-200);
		list.add(-300);
		list.add(-3);
		list.add(600);
		list.add(-20);
		list.add(-34);
		list.add(133);
		list.add(353);
		list.add(33);
		list.add(31);
		list.add(73);
		list.add(58);
		list.add(31);
		list.add(93);
		list.add(100);
		list.add(101);
		list.add(-100);
		list.add(156);
		list.add(3);
		list.add(4631);
		list.add(446);
		
		ThreeProduct p = new ThreeProduct(list);
		Assert.assertEquals("Product not correct", 1239255600, p.findProduct());
	}
	
	/**
	 * Tests for throwing of IllegalArgumentException when the product can't fit into an int
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testOverflow1() {
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MAX_VALUE);
		list.add(Integer.MAX_VALUE);
		list.add(-300);
		list.add(3);
		ThreeProduct p = new ThreeProduct(list);
		p.findProduct();
	}
	
	/**
	 * Tests for throwing of IllegalArgumentException when the product can't fit into an int
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testOverflow2() {
		List<Integer> list = new ArrayList<>();
		list.add(Integer.MIN_VALUE);
		list.add(Integer.MIN_VALUE);
		list.add(300);
		list.add(3);
		ThreeProduct p = new ThreeProduct(list);
		p.findProduct();
	}
}
