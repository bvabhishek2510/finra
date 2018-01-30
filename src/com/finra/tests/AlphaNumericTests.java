package com.finra.tests;

import org.junit.Test;

import com.finra.assignment.GenerateAlphaNumericNumber;

import static junit.framework.Assert.*;

import java.util.ArrayList;

public class AlphaNumericTests {
	
	GenerateAlphaNumericNumber alphaNumeric = new GenerateAlphaNumericNumber();
    ArrayList<String> resultString = new ArrayList<String>();
    String phoneNumber = "8768758783";
	String[] alphabets = {"0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    @Test
    public void getFirstAlphaNumericNumber(){
    	//here we are testing the first alphanumeric number for given number
    	StringBuilder temp = new StringBuilder(phoneNumber.substring(0,9));
    	alphaNumeric.alphaNumericConvertor(phoneNumber, alphabets, 9, temp, resultString);
        assertEquals("876875878d", resultString.get(0));
    }
    @Test
    public void getThirdAlphaNumericNumber(){
    	
    	//here we are testing the third alphanumeric number for given number
    	StringBuilder temp = new StringBuilder(phoneNumber.substring(0,9));
    	alphaNumeric.alphaNumericConvertor(phoneNumber, alphabets, 9, temp, resultString);
        assertEquals("876875878f", resultString.get(2));
    }
    
    @Test
    public void getAllAlphaNumericNumberForADigit(){
    	
    	//here we are testing the output for all alphanumeric number for 10th digit('3')
    	StringBuilder temp = new StringBuilder(phoneNumber.substring(0,9));
    	alphaNumeric.alphaNumericConvertor(phoneNumber, alphabets, 9, temp, resultString);
    	//as the result string is array list, so we are converting to string before we compare
        assertEquals("[876875878d, 876875878e, 876875878f]", resultString.toString());
    }                 
}