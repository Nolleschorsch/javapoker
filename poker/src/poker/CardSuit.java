package poker;
import java.util.Random;

public enum CardSuit {
	C, D, H, S;

	public static CardSuit randomSuit() {
		return CardSuit.values()[new Random().nextInt(CardSuit.values().length)];
	}
}