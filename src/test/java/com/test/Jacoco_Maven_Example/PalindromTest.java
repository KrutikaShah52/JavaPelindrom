package com.test.Jacoco_Maven_Example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PalindromTest {
	@Test
	public void whenPalindrom_thenAccept() {
	    PalindromeExample palindromeTester = new PalindromeExample();
	    assertTrue(palindromeTester.isPalindrome("noon"));
	}
	     
	@Test
	public void whenNearPalindrom_thanReject(){
	    PalindromeExample palindromeTester = new PalindromeExample();
	    assertFalse(palindromeTester.isPalindrome("sir"));
	}
}
