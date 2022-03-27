package poker;

public enum CardValue {
	DEUCE(2, "2", "Deuce"),
	THREE(3, "3", "Three"),
	FOUR(4, "4", "Four"),
	FIVE(5, "5", "Five"),
	SIX(6, "6", "Six"),
	SEVEN(7, "7", "Seven"),
	EIGHT(8, "8", "Eight"),
	NINE(9, "9", "Nine"),
	TEN(10, "T", "Ten"),
	JACK(11, "J", "Jack"),
	QUEEN(12, "Q", "Queen"),
	KING(13, "K", "King"),
	ACE(14, "A", "Ace");

	private final int value;
	private final String shortcutString;
	private final String verboseString;
	
	private CardValue(int value, String shortcutString, String verboseString) {
		this.value = value;
		this.shortcutString = shortcutString;
		this.verboseString = verboseString;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getShortcutString() {
		return this.shortcutString;
	}
	
	public String getVerboseString() {
		return this.verboseString;
	}
	
	public static CardValue getCardValueByInt(int i) {
		
		CardValue returnValue;
		
		switch(i) {
			case 2:
				returnValue = CardValue.DEUCE;
				break;
			case 3:
				returnValue = CardValue.THREE;
				break;
			case 4:
				returnValue = CardValue.FOUR;
				break;
			case 5:
				returnValue = CardValue.FIVE;
				break;
			case 6:
				returnValue = CardValue.SIX;
				break;
			case 7:
				returnValue = CardValue.SEVEN;
				break;
			case 8:
				returnValue = CardValue.EIGHT;
				break;
			case 9:
				returnValue = CardValue.NINE;
				break;
			case 10:
				returnValue = CardValue.TEN;
				break;
			case 11:
				returnValue = CardValue.JACK;
				break;
			case 12:
				returnValue = CardValue.QUEEN;
				break;
			case 13:
				returnValue = CardValue.KING;
				break;
			default:
				returnValue = CardValue.ACE;
				break;
		}
		
		return returnValue;
	}
	
}