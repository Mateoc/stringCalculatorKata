package com.talosdigital.kata.stringCalculator;

import java.util.regex.Pattern;

public class StringCalculator {
	
	public int add(String numbers) throws NegativeNumberException{
		if(numbers.equals("")){
			return 0;
		}
		String [] tokens = numbers.split(",|\n");
		int sum = 0;
		for (int i = 0; i<tokens.length; i++){
			if(isNumeric(tokens[i])){
				int num = Integer.parseInt(tokens[i]);
				if(num<0){
					String negatives = "" + num;
					for (; i<tokens.length; i++){
						num = Integer.parseInt(tokens[i]);
						if(num<0){
							negatives+=", "+num;
						}
					}
					throw new NegativeNumberException("Negatives not allowed: "+negatives);
				}else if(num>1000){
					continue;
				}
				sum += num;
			}else if(tokens[i].substring(0,2).equals("//")){
				String[] newDelims=tokens[i].substring(2).split(Pattern.quote("["));
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < newDelims.length; j++) {
					if(!newDelims[j].equals("")){
						sb.append("|"+Pattern.quote(newDelims[j].replace("]", "")));
					}
				}
				numbers="";
				for(int j = 1; j<tokens.length; j++){
					numbers+=tokens[j];
				}
				tokens = numbers.split(",|\n"+sb.toString());
				i=-1;
			}
		}
		return sum;
	}
	

	
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
		  Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
