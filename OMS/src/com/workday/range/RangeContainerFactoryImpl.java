/**
 * 
 */
package com.workday.range;

/**
 * @author Sudha Chinnappa
 * @Created Jul 6, 2016
 */
public class RangeContainerFactoryImpl implements RangeContainerFactory{

	@Override
	public RangeContainer createContainer(long[] data) {
		RangeContainer container = new RangeContainerImpl(data);
		return container;
	}

}
