package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import core.FixedCapacityStackOfStrings;

class CheckTest {

	@Before
	public void initialTest() 
	{
		stack = new FixedCapacityStackOfStrings(5);
	}

}
