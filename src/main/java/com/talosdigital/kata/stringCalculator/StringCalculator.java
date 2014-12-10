package com.talosdigital.kata.stringCalculator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class StringCalculator {
	/**
	 * 
	 * @param numbers 
	 * Numbers to be added plus optional new delimiters(by default , and \n)
	 * Note that the new delimiters can't be nor contain "[" or "]"
	 * The format for the delimiter is //< delimiter > for one char delimiter 
	 * or //[<delimiter>] for delimiter which its size its more than one 
	 * or //[<delimiter>][<delimiter>]... for more than one delimiter  
	 * @return 
	 * an int with the numbers added
	 * @throws NegativeNumberException
	 * It throw this exception when negative numbers are passed
	 */
	public int add(String numbers) throws NegativeNumberException{
		//is the argument it empty return 0
		if(StringUtils.isEmpty(numbers)){
			return 0;
		}
		//split the argument by the default delimiters /n and ,
		//initialize sum which will contain the sum of the valid numbers
		String [] tokens = numbers.split(",|\n");
		int sum = 0;
		//this loop will get all tokens and check if the are valid
		for (int i = 0; i<tokens.length; i++){
			//if the token its a number it enters the if and it get processed
			//else the token is a new delimiter and enter the else if
			//if the token doesn't comply 
			if(NumberUtils.isNumber(tokens[i])){
				//get the next number
				int num = Integer.parseInt(tokens[i]);
				//if the number its negative, gets all negatives and throw an exception
				//if the number its greater than 1000 ignores it
				if(num<0){
					//exceptionMessage will contain the message that will be thrown with the exception
					StringBuilder exceptionMessage = new StringBuilder();
					//Set the header of the massage
					exceptionMessage.append("Negatives not allowed: ");
					//Append the return of processNegatives
					exceptionMessage.append(processNegatives(tokens, i));
					//throw the exception with its message
					throw new NegativeNumberException(exceptionMessage.toString());
				}else if(num>1000){
					continue;
				}
				sum += num;
			}else if(tokens[i].substring(0,2).equals("//")){
				//delimiters contains all the new delimiters with out parsing them
				String delimiters = tokens[i].substring(2);
				//now splitedDelims have all the delimiters parsed or spliced
				//but without regex format
				String[] splitedDelims = delimiters.split(Pattern.quote("["));
				//regexBuilder will have all delimiters (default and custom) with regex format
				StringBuilder regexBuilder = new StringBuilder();
				//set the defaults delimiters
				regexBuilder.append(",|\n");
				for (int j = 0; j < splitedDelims.length; j++) {
					//the split may have created empty string and they should be ignored
					if(!StringUtils.isEmpty(splitedDelims[j])){
						//add a delimiter to previous one separated by | which is the or operand in regex
						regexBuilder.append("|").append(Pattern.quote(splitedDelims[j].replace("]", "")));
					}
				}
				//the loop just recreate the initial input without the custom delimiters 
				StringBuilder newNumbers = new StringBuilder();
				for(int j = 1; j<tokens.length; j++){
					newNumbers.append(tokens[j]);
				}
				tokens = newNumbers.toString().split(regexBuilder.toString());
				//start again
				i=-1;
			}
		}
		return sum;
	}
	
	/**
	 * 
	 * @param tokens
	 * Tokens containing the numbers to be process
	 * @param index
	 * The index at which the first negative was found
	 * @return
	 * A string containing all the negatives in tokens separated by ", "
	 */
	private String processNegatives(String[] tokens, int index){
		StringBuilder negatives = new StringBuilder();
		//get the last negative and appends it to the String builder
		int num = Integer.parseInt(tokens[index]);
		negatives.append(num);
		index++;
		//The loop find all negatives and append them to the String builder separated by ", "
		for (; index<tokens.length; index++){
			num = Integer.parseInt(tokens[index]);
			if(num<0){
				negatives.append(", ");
				negatives.append(num);
			}
		}
		return negatives.toString();
	} 
}
