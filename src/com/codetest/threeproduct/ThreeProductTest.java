package com.codetest.threeproduct;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ThreeProductTest {

	@Test(expected=IllegalArgumentException.class)
	public void testNull() {
		new ThreeProduct(null);
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void testLessThanThreeNumbers() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		new ThreeProduct(list);
	}
	
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
