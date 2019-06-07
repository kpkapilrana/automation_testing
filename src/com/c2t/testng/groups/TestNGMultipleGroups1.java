package com.c2t.testng.groups;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGMultipleGroups1 {
	
	@BeforeTest
	public void m1(){
		System.out.println("Hello...");
	}
	
	@Test(priority=2, groups={"sanity"})
	public void testMethodOne() {
		System.out.println("com.c2t.testng.groups.TestNGMultipleGroups1.testMethodOne()/sanity");
	}

	@Test(groups = { "sanity", "regression" })
	public void testMethodTwo() {
		System.out.println("com.c2t.testng.groups.TestNGMultipleGroups1.testMethodTwo()/sanity/regression");
	}

	@Test(priority=1, groups = { "sanity" })
	public void testMethodThree() {
		System.out.println("com.c2t.testng.groups.TestNGMultipleGroups1.testMethodThree()/sanity");
	}
	
	/*@Test(groups = {"g1","g2"})
	public void testMethodFour() {
		System.out.println("com.c2t.testng.groups.TestNGMultipleGroups1.testMethodFour()/regression");
	}*/
}
