/**
 * 
 */
package edu.my;

import java.io.Serializable;

/**
 * @author Sudha Chinnappa
 * @Created Jul 12, 2016
 * 
 *          A class is serializable if and when it implements the Serializable
 *          interface, which is an interface residing in the java.io package. If
 *          a class is serializable, it means that any object of that class can
 *          be converted into a sequence of bits so that it can be written to
 *          some storage medium (like a file), or even transmitted across a
 *          network.
 */
public class Serializables implements Serializable {

	private String username;
	// password variable will not serialize/persisthn
	private transient String password;

}
