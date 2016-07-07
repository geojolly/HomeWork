/**
 * 
 */
package com.workday.range.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.workday.range.*;

/**
 * @author Sudha Chinnappa
 * @Created Jul 6, 2016
 */
public class RangeQueryBasicTest {

	private RangeContainer rc;

	@Before
	public void setUp() {
		// RangeContainerFactory rf = (RangeContainerFactory) new
		// RangeContainerFactoryImpl();
		// rc = rf.createContainer(new long[] { 10, 12, 17, 21, 2, 15, 16 });
	}

	@Test
	public void runARangeQuery() {
		RangeContainerFactory rf = (RangeContainerFactory) new RangeContainerFactoryImpl();
		rc = rf.createContainer(new long[] { 10, 12, 17, 21, 2, 15, 16 });

		Ids ids = rc.findIdsInRange(14, 17, true, true);
		assertEquals(2, ids.nextId());
		assertEquals(5, ids.nextId());
		assertEquals(6, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		ids = rc.findIdsInRange(14, 17, true, false);
		assertEquals(5, ids.nextId());
		assertEquals(6, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
		assertEquals(3, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for duplicate values
		rc = rf.createContainer(new long[] { 10, 12, 17, 21, 2, 15, 16, 16, 16 });
		ids = rc.findIdsInRange(14, 17, true, true);
		assertEquals(2, ids.nextId());
		assertEquals(5, ids.nextId());
		assertEquals(6, ids.nextId());
		assertEquals(7, ids.nextId());
		assertEquals(8, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for fromValue = trueValue with every possible inclusive data
		ids = rc.findIdsInRange(17, 17, true, true);
		assertEquals(2, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());
		ids = rc.findIdsInRange(17, 17, true, false);
		assertEquals(Ids.END_OF_IDS, ids.nextId());
		ids = rc.findIdsInRange(17, 17, false, true);
		assertEquals(Ids.END_OF_IDS, ids.nextId());
		ids = rc.findIdsInRange(17, 17, false, false);
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for fromValue > toValue
		ids = rc.findIdsInRange(18, 16, true, true);
		assertEquals(Ids.END_OF_IDS, ids.nextId());
		// Test for values > than a long can hold. Behaves like fromValue >
		// toValue
		ids = rc.findIdsInRange(20, Long.MAX_VALUE + 1, false, true); // -1
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for -ve values
		ids = rc.findIdsInRange(-14, 17, true, true);
		assertEquals(0, ids.nextId());
		assertEquals(1, ids.nextId());
		assertEquals(2, ids.nextId());
		assertEquals(4, ids.nextId());
		assertEquals(5, ids.nextId());
		assertEquals(6, ids.nextId());
		assertEquals(7, ids.nextId());
		assertEquals(8, ids.nextId());
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for values not present in input
		ids = rc.findIdsInRange(22, 28, true, true); // -1
		assertEquals(Ids.END_OF_IDS, ids.nextId());

		// Test for empty container
		rc = rf.createContainer(new long[] {});
		ids = rc.findIdsInRange(18, 16, true, true);

		// Test for all 32K values
		Random random = new Random();
		long[] input = random.longs(32000, 10, 20).toArray();
		rc = rf.createContainer(input);
		ids = rc.findIdsInRange(14, 17, true, true);
	}
}
