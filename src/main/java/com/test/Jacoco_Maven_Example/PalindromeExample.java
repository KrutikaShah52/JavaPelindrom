 package com.test.Jacoco_Maven_Example;

public class PalindromeExample {

	public boolean isPalindrome(String inputString) {
	    if (inputString.length() == 0) {
	    	System.out.println("If condotion execute...............");
	        return true;
	    } else {
	        char firstChar = inputString.charAt(0);
	        char lastChar = inputString.charAt(inputString.length() - 1);
	        String mid = inputString.substring(1, inputString.length() - 1);
	        System.out.println("Else condition execute.......");
	        return (firstChar == lastChar) && isPalindrome(mid);
	    }
	}	
	
	public void lengthof(String inputString) {
		if (inputString.length() == 1) {
	    	System.out.println("Length is not applicable");
	    }
	}
	public void sayhi(){
		if(1!=1){
			System.out.println("Hello for function");		
		}
		else{
			System.out.println("Hi in else loop");
		}
	}
}
