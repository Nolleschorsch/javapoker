package poker;

public enum HandType {
	
	StraightFlush(0),
	FourOfAKind(1),
	FullHouse(2),
	Flush(3),
	Straight(4),
	ThreeOfAKind(5),
	TwoPair(6),
	Pair(7),
	HighCard(8);

	private final int rank;
	
	private HandType(int rank) {
		this.rank = rank;
	}
	
	public int getRank() {
		return this.rank;
	}
	
}
