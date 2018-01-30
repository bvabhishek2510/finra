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
    	StringBuilder temp = new StringBuilder(phoneNumber.substring(0,8));
    	alphaNumeric.alphaNumericConvertor(phoneNumber, alphabets, 8, temp, resultString);
        assertEquals("87687587tf", resultString.get(2));
    }
    
    @Test
    public void getAllAlphaNumericNumberForADigit(){
    	
    	//here we are testing the output for all alphanumeric number for 10th digit('7')
    	StringBuilder temp = new StringBuilder(phoneNumber.substring(0,7));
    	alphaNumeric.alphaNumericConvertor(phoneNumber, alphabets, 7, temp, resultString);
    	//as the result string is array list, so we are converting to string before we compare
        assertEquals("[8768758ptd, 8768758pte, 8768758ptf, 8768758pud, 8768758pue, 8768758puf, 8768758pvd, 8768758pve, 8768758pvf, 8768758qtd, 8768758qte, 8768758qtf, 8768758qud, 8768758que, 8768758quf, 8768758qvd, 8768758qve, 8768758qvf, 8768758rtd, 8768758rte, 8768758rtf, 8768758rud, 8768758rue, 8768758ruf, 8768758rvd, 8768758rve, 8768758rvf, 8768758std, 8768758ste, 8768758stf, 8768758sud, 8768758sue, 8768758suf, 8768758svd, 8768758sve, 8768758svf]", resultString.toString());
    }                 
}