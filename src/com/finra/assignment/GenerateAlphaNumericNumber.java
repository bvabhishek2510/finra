package com.finra.assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GenerateAlphaNumericNumber extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PrintWriter pw;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		//getting the user phone number
		String phone = req.getParameter("phoneNumber");
		//array for alpha-numeric telephone keypad
		 String[] alphabets = {"0","1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        ArrayList<String> resultString = new ArrayList<String>();
	        //ignoring first 3 digits (area code cannot be replaced with alphanumerics) and replacing the remaining string with alpha numerics
	        for(int j=phone.length()-1; j>=3;j--){
	        	 StringBuilder temp = new StringBuilder(phone.substring(0,j)); 
	 	        alphaNumericConvertor(phone, alphabets, j, temp, resultString);
	        }

	        res.setContentType("text/plain");
	        //writing the final output
	        res.getWriter().write(resultString.toString());
	}
	public void alphaNumericConvertor(String digits, String[] alphabets, int digit, StringBuilder temp, ArrayList<String> resultString){
		//after completing all the digits adding the string to the result
        if(digit == digits.length()){
            resultString.add(temp.toString());
            return;
        }
        else{
        	//getting the number of a particular position in the given number and looping through the corresponding alphabets from the array
        	//Example 1235678904 for position 4 the digit is 6 and the alphabets are 'mno'. In the following loop iterates for 3 times
            for(int i = 0; i < alphabets[digits.charAt(digit) - '0'].length(); i++){
                temp.append(alphabets[digits.charAt(digit) - '0'].charAt(i));
                alphaNumericConvertor(digits, alphabets, digit+1, temp, resultString);
                temp.deleteCharAt(temp.length()-1);
                
            }
        }
    }
    
}
