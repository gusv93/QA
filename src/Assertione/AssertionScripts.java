package Assertione;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionScripts {

	
	
	@Test
	public void test1()
	{
		String mystr="Test assertTrue";
		Assert.assertTrue(mystr.contains("Tesdvst"),"String is not matching");
		
	}
	@Test
	public void test2()
	{
		
		Assert.assertTrue(false);
	
	}
	
}
