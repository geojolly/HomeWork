/**
 * 
 */
package com.workday.range;

import java.util.Enumeration;

/**
 * @author Sudha Chinnappa
 * @Created Jul 6, 2016
 */
public class IdsImpl implements Ids {

	private Enumeration<Short> ids;
	
	/**
	 * @param enumeration
	 */
	public IdsImpl(Enumeration<Short> ids) {
		this.ids = ids;
	}

	@Override
	public short nextId() {
		if(ids.hasMoreElements()){
			return ids.nextElement();
		}
		return END_OF_IDS;
	}

}
