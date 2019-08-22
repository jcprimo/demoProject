package Movio;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author julio
 *
 */
public class PinGenerator {

	private static final int TOTAL_PINS = 1000;

	 /**
     * Exercise 2
     * 
     * Write a library for generating random PIN codes. You probably know what a
     * PIN code is; its a short sequence of numbers, often used as a passcode
     * for bank cards.
     * 
     * Here are the requirements:
     * 
     * The library should export a function that returns a batch of 1,000 PIN
     * codes in random order Each PIN code in the batch should be unique Each
     * PIN should be: 4 digits long Two consecutive digits should not be the
     * same (e.g. 1156 is invalid) Three consecutive digits should not be
     * incremental (e.g. 1236 is invalid) The library should have automated test
     */
	public PinGenerator() {}
    
	/**
	 * Generate a new batch of pins numbers by using the total pins on this
	 * class.
	 * 
	 * @return the collection of all valid pin numbers
	 */
    public Set<Pin> generatePinNumbers() 
    {
        //This will guarantee us to have 1000 unique pin numbers
        Set<Pin> validPinNumbers = new HashSet<>();
        //Generate the total pins desired
        while(validPinNumbers.size() < TOTAL_PINS)
        {
//            int validPin = createNewValidPin();
        	Pin validPin = new Pin(createNewValidPin());
            validPinNumbers.add(validPin);
        }
        return validPinNumbers;
    }
    
	/**
     * Creates a new valid pin. A valid pin is defined by
     * a non-sequential non-incremental number. Example of bad pins
     * sequential: 1124, 7334, 0199
     * incremental: 0128, 1789, 5678
     * 
     * @return the valid pin number
     */
    //This method creates a new valid pin and returns that valid pin
    private int createNewValidPin()
	{
    	//Generates the first number consisting of 4 digits
		int validPin = (int) (Math.random() * 9000) + 1000;
		// turn the 4-digit pin into an array
		int[] validPinArr = PinUtils.turnPinIntoArray(validPin);
		
		boolean isPinValid = false;
		// If the given pin is not valid then create a new one until it meets
		// the requirements
		while (!isPinValid) 
		{
			// If it is sequenced or 
			// if it is incremental then generate a new pin
			if (PinUtils.isSequenced(validPinArr)
					|| PinUtils.isIncrementalByThreeDigits(validPinArr))
			{
				// Generates the 4-digit pin number
				validPin = (int) (Math.random() * 9000) + 1000;
				validPinArr = PinUtils.turnPinIntoArray(validPin);
			} 
			else 
			{
				isPinValid = true;
			}
		}
		return validPin;
	}
}
