/**
 * 
 */
package edu.my;

/**
 * @author Sudha Chinnappa
 * @Created Jul 12, 2016
 */
public class Exceptions {

	public static void main(String[] args) {
		System.out.println(returnAnInt());
		try {
			System.out.println(returnAnIntAndException());
		} catch (Exception e) {
			System.out.println("Exception caught in main method");
		}

		System.out.println(overwriteReturn()); // Prints 400
	}

	@SuppressWarnings("finally")
	public static int returnAnInt() {
		try {
			// return 50; //This is overwritten by return statement in finally.
			throw new Exception();
		} catch (Exception x) {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("I am inside the catch");
			}
		} finally {
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("I am inside the catch in finally");
			}
			System.out.println("I am in finally");
			return 100; // Supress the exception thrown
		}
	}

	@SuppressWarnings("finally")
	/*
	 * if the finally block returns a value, it will override any exception
	 * thrown in the try/catch block.
	 */
	public static int returnAnIntAndException() {
		try {
			// return 50; //This is overwritten by return statement in finally.
			throw new NoSuchFieldException();
		} finally {
			System.out.println("I am in finally");
			return 200; // Supress the exception thrown
		}
	}

	/*
	 * If you have a return statement in both the finally block and the try
	 * block, then you could be in for a surprise. Anything that is returned in
	 * the finally block will actually override any exception or returned value
	 * that is inside the try/catch block
	 */
	@SuppressWarnings("finally")
	public static int overwriteReturn() {
		try {
			return 300;
		} finally {
			return 400;
		}
	}

}
