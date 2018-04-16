package com.test.Jacoco_Maven_Example;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
	
//	@Test
//	public void whenPalinrome_thenAccept(){
//	    PalindromeExample palindromeTester = new PalindromeExample();
//	    assertEquals(true, palindromeTester.isPalindrome("aba"));
//	}
	
//	@Test
//	public void NearPalindrom_thanReject(){
//	    PalindromeExample palindromeTester = new PalindromeExample();
//	    assertFalse(palindromeTester.isPalindrome("abcdef"));
//	}
}
