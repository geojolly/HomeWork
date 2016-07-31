/**
 * 
 */
package edu.my.accessLevel.firstPackage;

/**
 * @author Sudha Chinnappa
 * @Created Jul 12, 2016
 */
public class B {

	public void someMethod() {
		A newInstance = new A();
		newInstance.f1 = 20;
		newInstance.i1 = 30;

		// Cannot access f1 and i1 directly without the instance. Like how its
		// done in class C
	}
}

class D extends A {

	public void someMethod() {

		// Access variables without the instance
		f1 = 20;
		i1 = 30;
	}
}
