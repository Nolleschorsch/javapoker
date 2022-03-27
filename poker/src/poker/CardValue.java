package poker;

public enum CardValue {
	Deuce(2, "2"),
	Three(3, "3"),
	Four(4, "4"),
	Five(5, "5"),
	Six(6, "6"),
	Seven(7, "7"),
	Eight(8, "8"),
	Nine(9, "9"),
	Ten(10, "T"),
	Jack(11, "J"),
	Queen(12, "Q"),
	King(13, "K"),
	Ace(14, "A");

	private final int value;
	private final String shortcutString;
	
	private CardValue(int value, String shortcutString) {
		this.value = value;
		this.shortcutString = shortcutString;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String getShortcutString() {
		return this.shortcutString;
	}
	
	public static CardValue getCardValueByInt(int i) {
		
		CardValue returnValue;
		
		switch(i) {
			case 2:
				returnValue = CardValue.Deuce;
				break;
			case 3:
				returnValue = CardValue.Three;
				break;
			case 4:
				returnValue = CardValue.Four;
				break;
			case 5:
				returnValue = CardValue.Five;
				break;
			case 6:
				returnValue = CardValue.Six;
				break;
			case 7:
				returnValue = CardValue.Seven;
				break;
			case 8:
				returnValue = CardValue.Eight;
				break;
			case 9:
				returnValue = CardValue.Nine;
				break;
			case 10:
				returnValue = CardValue.Ten;
				break;
			case 11:
				returnValue = CardValue.Jack;
				break;
			case 12:
				returnValue = CardValue.Queen;
				break;
			case 13:
				returnValue = CardValue.King;
				break;
			default:
				returnValue = CardValue.Ace;
				break;
		}
		
		return returnValue;
	}
	
}