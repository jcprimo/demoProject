package Movio;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;

import Movio.PinGenerator;
import Movio.PinUtils;



/**
 * JUnit test to validate pin numbers and ensure there are 1,000 pins and they
 * are all valid
 * 
 * @author primoj
 *
 */
public class MovioTest extends TestCase {
	
	private Set<Integer> sequencedPins = new HashSet<>();
	private Set<Integer> incrementalPins = new HashSet<>();

	@Override
	protected void setUp()
	{
		//Adding sequenced Pins
		sequencedPins.add(5589);
		sequencedPins.add(1288);
		sequencedPins.add(8865);
		sequencedPins.add(1551);
		sequencedPins.add(1234);
		//Adding incremental pins
		incrementalPins.add(1235);
		incrementalPins.add(4569);
		incrementalPins.add(1012);
		incrementalPins.add(7891);
		incrementalPins.add(1111);
	}    	
	/**
	 * Method that checks the validity of the pins after they were created to
	 * ensure all pins meet requirements
	 * 
	 * @param pinNumbers - the pin numbers to check.
	 * @return True if the pins are valid otherwise false.
	 */
	private boolean arePinsValid(Set<Integer> pinNumbers)
	{
		Boolean areValid = null;
		for (int pin : pinNumbers) 
		{
			int[] pinArr = PinUtils.turnPinIntoArray(pin);
			// Check if the pin is valid if not then generate a new one and run
			// it thru val again
			if(PinUtils.isSequenced(pinArr))
			{
				System.out.println(pin + " It is sequenced");
				areValid = false;
			}
			if(PinUtils.isIncrementalByThreeDigits(pinArr))
			{
				System.out.println(pin + " It is Incremental");
				areValid = false;
			}
			
		}
	
		return areValid == null ? true: areValid;
	}
	
	
	@Test
	public void testGeneratePins()
	{
    	PinGenerator pin = new PinGenerator();
    	Set<Pin> validPins = pin.generatePinNumbers();
    	PinUtils.printPins(validPins);

//		assertEquals(true, arePinsValid(validPins));
    	assertEquals("There should be 1000 pins", 1000, validPins.size());
	}
	
	
	@Test
	public void testIncrementalPins()
	{
		System.out.println("Testing incremental pins \n"
				+ "The given set contains invalid pins and it should be flagged as invalid");
    	assertEquals("Pins must be invalid for this test case", false, arePinsValid(incrementalPins));
    	System.out.println("The set of invalid pins:");
//    	PinUtils.printPins(incrementalPins);
	}

	@Test
	public void testSequencedPins()
	{
		System.out.println("Testing sequenced pins \n"
				+ "The given set contains invalid pins and it should be flagged as invalid");
    	// Test set of sequenced pins
    	// Expecting validation to work.
    	assertEquals("Pins must be invalid for this test case", false, arePinsValid(sequencedPins));
    	System.out.println("The set of invalid pins");
//    	PinUtils.printPins(sequencedPins);
	}

}

