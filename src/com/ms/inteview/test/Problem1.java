package com.ms.inteview.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> dictionary = new ArrayList<>();
		
		dictionary.add("This");
		dictionary.add("a");
		dictionary.add("is");
		dictionary.add("Test");
		dictionary.add("Sample");
		dictionary.add("some");
		dictionary.add("so");
		//dictionary.add("me");
		dictionary.add("people");
		
		String strToBeValidated = "somepeople";
		
		
		List<String> dicWord = dictionary.stream().sorted((o1, o2) -> {
			return compare(o1, o2);
		}).collect(Collectors.toList());
		List<Integer> dicWordLength =  dicWord.stream().mapToInt(s -> s.length()).boxed().collect(Collectors.toList());
		
		
		List<Integer> dicWordlen = dictionary.stream()
									   	 	  .mapToInt(s -> s.length())
									   	 	  .boxed()
									   	 	  .sorted((no1, no2) -> no2 > no1 ? 1 : (no2 < no1 ? -1 : 0))
									   	 	  .collect(Collectors.toList());
				//collect(Collectors.toList()).sort((no1, no2) -> no2 > no1 ? 1 : (no2 < no1 ? -1 : 0) );
		
		
		
		
		
		dicWordlen.forEach(i -> System.out.println(i));		
		
		//dicWordLength.forEach(s -> System.out.println(s));
		boolean found = false;
		boolean notFound = false;
		List<String> result = new ArrayList<>();
		for(int i=0;i<strToBeValidated.length(); ) {
			found = false;
			notFound = false;
			for(int l : dicWordLength) {
				String token = "";
				try {
 					 token = strToBeValidated.substring(i, i+l);
 				}catch(Exception e) {
 					
 				}
				
				
				if(dicWord.contains(token)) {
					found = true;
					i = i + l -1;
					result.add(token);
					break;
				}
				
				
			}
			if(!found) {
				System.out.println("Not found.. :(");
				return;
			}
			
			i++;
		}
		
		result.forEach(s -> System.out.println(s + " "));
		
/*		if(notFound) {
			System.out.println("Not found...  :(");
		}
		if(found) {
			result.forEach(s -> System.out.println(s + " "));
		}
*/		
		
		
	}

	private static int compare(String o1, String o2) {
		if (o2.length() > o1.length()) {
			return 1;
		} else if (o2.length() < o1.length()) {
			return -1;
		} else {
			return 0;
		}
	}

}
