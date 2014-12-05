package Katas.stringCalculator;

import java.util.StringTokenizer;

public class StringCalculator {
	
	public int add(String numbers)throws Exception{
		StringTokenizer st = new StringTokenizer(numbers, ",\n");
		int sum = 0;
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			if(isNumeric(token)){
				int num = Integer.parseInt(token);
				if(num<0){
					String negatives = ""+num;
					while(st.hasMoreTokens()){
						num = Integer.parseInt(token);
						if(num<0){
							negatives+=", "+num;
						}
					}
					throw new Exception("Negatives not allowed: "+negatives);
				}else if(num>1000){
					continue;
				}
				sum += num;
			}else if(token.substring(0,2).equals("//")){
				st = new StringTokenizer(numbers.substring(2),",\n"+numbers.substring(2,3));
			}else{
				return 0;
			}
		}
		return sum;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    int d = Integer.parseInt(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
}
