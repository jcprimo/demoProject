package Movio;

/**
 * POJO for a pin Number
 * @author julio
 *
 */
public class Pin implements Comparable<Pin>{
	
	private Integer pin;
	private String sNumber;
	
	public Pin(int pin)
	{
		this.pin = pin;
	}
	public int getPin() {
		return pin;
	}
	public String getsNumber() {
		return String.valueOf(pin);
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}
	@Override
	public int compareTo(Pin o) {
		if (this.pin == o.pin)
			return 0;
		else if (this.pin > o.pin)
			return 1;
		else
			return -1;
	}
}
