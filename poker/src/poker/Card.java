package poker;
public class Card implements Comparable<Card>{

	private CardSuit suit;
	private CardValue value;
	
	
	public Card(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	public CardSuit getSuit() {
		return this.suit;
	}

	public CardValue getValue() {
		return this.value;
	}
	
	public int getNumericValue() {
		return this.value.getValue();
	}
	
	public String toString() {
		return String.format("%s%s", this.value, this.suit);
	}
	
	public int compareTo(Card card) {
        return this.getNumericValue() > card.getNumericValue() ? -1 : this.getNumericValue() < card.getNumericValue() ? 1 : 0;
    }
	
}
