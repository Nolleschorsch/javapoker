package poker;

public enum CardValue {
	Deuce(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(11),
	Queen(12),
	King(13),
	Ace(14);

	private final int value;
	
	CardValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
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