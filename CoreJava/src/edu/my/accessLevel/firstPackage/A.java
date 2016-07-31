/**
 * 
 */
package edu.my.accessLevel.firstPackage;

/**
 * @author Sudha Chinnappa
 * @Created Jul 12, 2016
 * 
 *          Modifier - Class - Package - SubClass - World
 * 
 *          public - Y - Y - Y - Y
 * 
 *          protected - Y - Y - Y - N
 * 
 *          No Modifier - Y - Y - N - N
 * 
 *          private - Y - N - N - N
 */

public class A {
	float f1;		//No Modifier - only visible here and classes in the same package
	protected int i1;	//Visible here, classes in the same package and in sub classes
}
