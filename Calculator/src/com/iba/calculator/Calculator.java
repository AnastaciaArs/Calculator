package com.iba.calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	private double number1;
	private double number2;
	private MathOperator operator;
	
	private void getNumber(){
		Scanner s = new Scanner(System.in);
		try{
			System.out.println("Input first number: ");
			this.number1  = s.nextDouble();
			System.out.println("Input second number: ");
			this.number2  = s.nextDouble();
			System.out.println("Input math operator: ");
			this.operator = MathOperator.valueOf(s.next());
			//System.out.println(number1);
			//System.out.println(number2);
			//System.out.println(operator);
		}
		catch(InputMismatchException e){
			System.out.println("Sorry, your number was wrong.");
		}
		catch(IllegalArgumentException e){
			System.out.println("Sorry, your math operator was wrong.");
		}
		finally{
			s.close();
		}
	}

	private double doCalculations(){
		double res = 0.0;
		switch (this.operator){
		case PLUS: 
			res = this.number1+this.number2; 
			break;
		case MINUS: 
			res = this.number1-this.number2; 
			break;
		case MULTIPLY:
			res = this.number1*this.number2; 
			break;
		case DIVIDE:
			if (this.number2==0.0){ 
				System.out.println("Divide by zero.");
				return -1;
				}
			else
				res = this.number1/this.number2; 
			break;
		case COPY_SIGN:
			res = Math.copySign(number1, number2); 
			break;
		case IEEE_REMAINDER:
			res = Math.IEEEremainder(number1, number2);
			break;
		case NEXT_AFTER:
			res = Math.nextAfter(number1, number2);
			break;
		case MIN:
			res = Math.min(number1, number2);
			break;
		case MAX:
			res = Math.max(number1, number2);
			break;
		case SQRT:
			res = Math.sqrt(this.number1); 
			break;	
		case POW:
			res = Math.pow(this.number1,this.number2); 
			break;	
		default:
			break;	
		}
		return res;
	}

    public void getResult(){
    	this.printOperations();
    	this.getNumber();
    	if (this.operator!=null){
    		double res = this.doCalculations();
    		System.out.println("Your result "+ res);
    	}
    }
    
    private void printOperations(){
    	System.out.println("List of math operations in my Calculator:");
    	System.out.println(" - PLUS\n - MINUS\n - MULTIPLY\n - DIVIDE\n - SQRT");
    	System.out.println(" - MAX\n - MIN\n - POW");
    	System.out.println(" - COPY_SIGN - returns the first floating-point argument with the sign of the second floating-point argument.");
    	System.out.println(" - IEEE_REMAINDER - computes the remainder operation on two arguments as prescribed by the IEEE 754 standard.");
    	System.out.println(" - NEXT_AFTER - returns the floating-point number adjacent to the first argument in the direction of the second argument.\n");
    }
}
