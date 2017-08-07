package Assertione;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts2 {

	
	
	@Test
	public void test1()
	{
		System.out.println("Test Case 1 started ");
		Assert.assertEquals(12, 13);
		System.out.println("Test Case 1 completed ");
	}
	@Test
	public void test2()
	{
		System.out.println("Test Case 2 started ");
		Assert.assertEquals(12, 13, "Dropdown count doesn't match please check with developers");
		System.out.println("Test Case 2 completed ");
	}
	
	@Test
	public void test3()
	{
		System.out.println("Test Case 3 started ");
		Assert.assertEquals("Hello", "Hello", "Words doen't match please raise a bug");
		System.out.println("Test Case 3 completed ");
		
	}
}
