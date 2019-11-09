package com.presto.qe.Scripts;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.presto.qe.Pages.AmazonHome;


public class TestAmazon  {

	private AmazonHome amazonHome;
	
	@Before
	public void setUp() throws Exception {
		amazonHome = new AmazonHome();
		
	}

	@After
	public void tearDown() throws Exception {
		amazonHome.quit();
	}

	@Test
	public void test() {
		amazonHome.typeInSearchBox("Headphones");
		amazonHome.clickSearchButton();
		amazonHome.addAllBestSellers();
	}

}
