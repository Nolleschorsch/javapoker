package poker;

public enum HandType {
	
	STRAIGHTFLUSH(0, "StraightFlush"),
	FOUROFAKIND(1, "FourOfAKind"),
	FULLHOUSE(2, "FullHouse"),
	FLUSH(3, "Flush"),
	STRAIGHT(4, "Straight"),
	THREEOFAKIND(5, "ThreeOfAKind"),
	TWOPAIR(6, "TwoPair"),
	PAIR(7, "Pair"),
	HIGHCARD(8, "HighCard");

	private final int rank;
	private final String name; 
	
	private HandType(int rank, String name) {
		this.rank = rank;
		this.name = name;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public String getName() {
		return this.name;
	}
	
}
