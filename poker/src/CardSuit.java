import java.util.Random;

enum CardSuit {
	C, D, H, S;

	public static CardSuit randomSuit() {
		return CardSuit.values()[new Random().nextInt(CardSuit.values().length)];
	}
}
