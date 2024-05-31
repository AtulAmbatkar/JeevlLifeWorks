package com.jeevLifeworks;

import java.util.Scanner;

public class UserDetails {
	
	public static void main(String[] args) {
		
		Scanner scn = null;
		try {
			scn = new Scanner(System.in);
			System.out.print("Enter the first integer: ");
			int firstNumber = scn.nextInt();
			
			System.out.print("Enter the Second integer: ");
			int secondNumber = scn.nextInt();
			
			System.out.print("Enter a floating-point number: ");
			float floatNumber = scn.nextFloat();
			
			System.out.print("Enter a single character: ");
			char singleCharacter = scn.next().charAt(0);
			
			System.out.print("Enter boolean value (true/false) : ");
			boolean booleanValue = scn.nextBoolean();
			
			System.out.print("Enter your name : ");
			String name = scn.next();
			scn.nextLine();
		
			//function to perform the numer operation
			numberOperation(firstNumber,secondNumber,floatNumber);
			// function to perform the String and character operation
			performDataOperation(singleCharacter,booleanValue,name);
			
		}catch(Exception e) {
			System.out.println("Exception occurred in UserDetails class "+e.getMessage());
		}finally {
			if(null !=  scn) {
				scn.close();
			}
		}
	}
	
	private static void numberOperation(int firstNumber, int secondNumber, float floatNumber) {
		int sumNumber = firstNumber + secondNumber;
		System.out.println("Sum of " + firstNumber + " and " + secondNumber + " is: "+sumNumber);
		int differance = firstNumber - secondNumber;
		System.out.println("Difference between " + firstNumber + " and " + secondNumber + " is: "+differance);
		int product = firstNumber * secondNumber;
		System.out.println("Product of " + firstNumber + " and " + secondNumber + " is: "+product);
		float result = floatNumber*2;
		System.out.println(floatNumber +" multiplied by 2 is: " +result);
	}
	
	private static void performDataOperation(char singleCharacter, boolean booleanValue, String name) {
		
		System.out.println("The next character after " + singleCharacter + " is: "+(++singleCharacter));
		System.out.println("The oppesite "+booleanValue + " is: "+!booleanValue);
		System.out.println("Hello,"+name+" Welcome jeevLifeWorks !");

	}

}
