/**
 * 
 */
package com.workday.range;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Sudha Chinnappa
 * @Created Jul 6, 2016
 */
public class RangeContainerImpl implements RangeContainer {

	/*
	 * Requirements: Unsorted collection
	 * 
	 * Collection that can retrieve data fast
	 * 
	 * Collection that can hold huge data - 32k items or less
	 * 
	 * Duplicates allowed - This is my assumption
	 * 
	 * Immutable container
	 * 
	 * 
	 */
	Map<Long, ArrayList<Short>> ImmutableContainer;

	/**
	 * @param data
	 */
	public RangeContainerImpl(long[] data) {
		HashMap<Long, ArrayList<Short>> mutableContainer = new HashMap<Long, ArrayList<Short>>();
		for (short index = 0; index < data.length; index++) {
			mutableContainer.putIfAbsent(data[index], new ArrayList<Short>());
			ArrayList<Short> values = mutableContainer.get(data[index]);
			// Increment index by 1 to get the position of the value in the data
			// array. E.g, data[5]=2000 means that employee #6 has net pay of
			// 2000
			//values.add((short) (index + 1));
			values.add((short) (index));
		}

		// Copy values from mutableContainer to ImmutableContainer
		ImmutableContainer = Collections.unmodifiableMap(mutableContainer);
		// Set the value of mutableContainer to null to avoid modifications
		mutableContainer = null;
	}

	@Override
	public Ids findIdsInRange(long fromValue, long toValue, boolean fromInclusive, boolean toInclusive) {
		if (!fromInclusive) {
			fromValue++;
		}
		if (!toInclusive) {
			toValue--;
		}
		
		//TODO: Implementation question: what is the expected behavior when toValue < fromValue
		
		ArrayList<Short> values = new ArrayList<Short>();
		
		for(Long key:ImmutableContainer.keySet()){
			if (key >=fromValue && key <=toValue){
				values.addAll(ImmutableContainer.get(key));
			}
		}

		/*while (fromValue <= toValue) {
			ArrayList<Short> value = ImmutableContainer.get(fromValue);
			if (value != null) {
				values.addAll(ImmutableContainer.get(fromValue));
			}
			fromValue++;
		}*/

		//Sort values
		Collections.sort(values);
		Ids ids = new IdsImpl(Collections.enumeration(values));
		
		return ids;
	}
}
