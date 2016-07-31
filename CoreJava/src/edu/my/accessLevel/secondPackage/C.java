/**
 * 
 */
package edu.my.accessLevel.secondPackage;

import edu.my.accessLevel.firstPackage.A;

/**
 * @author Sudha Chinnappa
 * @Created Jul 12, 2016
 */
public class C extends A {

	public void someMethod() {
		A newInstance = new A();
		// Cannot access variable through instance.
		// newInstance.i1
		i1 = 50;
		// f1 = 100;
	}
}
