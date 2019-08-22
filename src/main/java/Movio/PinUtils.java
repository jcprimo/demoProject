package Movio;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Utility class for pin generator.
 * 
 * @author primoj
 *
 */
public class PinUtils {

	/**
	 * Checks if the given pin it is sequenced. Sequence consists of having the same
	 * digit next to each other.
	 * 
	 * @param pin - the pin to check for sequencing
	 * @return true if it is sequenced otherwise false.
	 */
    public static boolean isSequenced(int[]pin)
	{
		// It is assumed that it is not sequenced
		// (or contain the same number next to each other)
		for (int i = 0; i < pin.length - 1; i++) {
			if (pin[i] == pin[i + 1]) {
				return true;
			}
		}
		return false;
	}
    
    /**
     * Checks if the given pin consists of incremental digits.
     * An incremental pin consists of three digits such as n, n+1, n+2
     * e.g. 1236 is sequenced, 4789 is sequenced.
     * 
     * @param pin - The pin to check for sequencing
     * @return true if it is sequenced otherwise false.
     */
    public static boolean isIncrementalByThreeDigits(int[]pin)
	{
		// we will just check 0-pos and 1-pos
		for (int i = 0; i < 2; i++) {
			int digit1 = pin[i];
			if (digit1 + 1 == pin[i + 1]) {
				// then check next pos
				if (digit1 + 2 == pin[i + 2]) {
					return true;
				}
			}
		}
		return false;
	}
    
    /**
     * Given the collection of pins it prints out the pins by a counter and the ping number
     * Example: 
     * 1. 1652
     * 2. 9834
     * 
     * @param pinNumbers the Pin numbers to print
     */
	public static void printPins(Set<Pin>pinNumbers)
    {
        //Sort the set
        List<Pin> sortedPins = new ArrayList<>(pinNumbers);
        Collections.sort(sortedPins);
        int counter = 1;
        for(Pin pin : sortedPins)
        {
        	String pinNum = pin.getsNumber();
            System.out.print(counter + ". ");
            System.out.println(pinNum);
            counter++;
        }
    } 
	
    /**
	 * Turn pin into array
	 * 
	 * @param pin - the pin to turn it into an array.
	 */
    public static int[] turnPinIntoArray(int pin)
    {
        String pinString = Integer.toString(pin);
        //No need to check for length since we know it is a 4 digit pins
        int[] pinArray = new int[pinString.length()];
        //Research why -'0' and explain it
        for (int i = 0; i < pinArray.length; i++) {
        	//Turns the ASCII value into an integer representation
            pinArray[i] = pinString.charAt(i) - '0'; 
        }
        return pinArray;
    }
}
